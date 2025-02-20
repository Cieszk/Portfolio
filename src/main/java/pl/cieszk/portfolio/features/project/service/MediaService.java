package pl.cieszk.portfolio.features.project.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cieszk.portfolio.core.exception.custom.ResourceAlreadyExistsException;
import pl.cieszk.portfolio.features.project.request.MediaRequest;
import pl.cieszk.portfolio.features.project.mapper.MediaMapper;
import pl.cieszk.portfolio.features.project.model.Media;
import pl.cieszk.portfolio.features.project.model.Project;
import pl.cieszk.portfolio.features.project.repository.MediaRepository;
import pl.cieszk.portfolio.features.project.repository.ProjectRepository;
import pl.cieszk.portfolio.features.project.response.MediaResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final MediaRepository mediaRepository;
    private final ProjectRepository projectRepository;
    private final MediaMapper mediaMapper;

    public MediaResponse addMedia(MediaRequest mediaRequest) throws ResourceAlreadyExistsException {
        if (mediaRepository.existsByUrl(mediaRequest.getUrl())) {
            throw new ResourceAlreadyExistsException("Resource with given url already exists");
        }
        Media media = mediaMapper.toEntity(mediaRequest);
        Project project = projectRepository.findById(mediaRequest.getProject_id())
                        .orElseThrow(() -> new EntityNotFoundException("Project with given id not found"));
        media.setProject(project);
        media = mediaRepository.save(media);
        return mediaMapper.toResponse(media);
    }

    public MediaResponse getMedia(Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Media with given id not found"));
        return mediaMapper.toResponse(media);
    }

    public List<MediaResponse> getAllMediaByProject(Long projectId) {
        List<Media> mediaList = mediaRepository.getAllByProject_Id(projectId);
        return mediaMapper.toResponseList(mediaList);
    }

    public MediaResponse updateMedia(MediaRequest request, Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Media with given id not found"));
        mediaMapper.updateEntityFromRequest(request, media);
        media = mediaRepository.save(media);
        return mediaMapper.toResponse(media);
    }

    public void deleteMedia(Long id) {
        if (!mediaRepository.existsById(id)) {
            throw new EntityNotFoundException("Media with given id not found");
        }
        mediaRepository.deleteById(id);
    }
}
