package pl.cieszk.portfolio.features.about.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cieszk.portfolio.features.about.mapper.AboutMapper;
import pl.cieszk.portfolio.features.about.model.About;
import pl.cieszk.portfolio.features.about.repository.AboutRepository;
import pl.cieszk.portfolio.features.about.request.AboutRequest;
import pl.cieszk.portfolio.features.about.response.AboutResponse;
import pl.cieszk.portfolio.features.project.mapper.MediaMapper;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutRepository aboutRepository;
    private final AboutMapper aboutMapper;

    public AboutResponse addAbout(AboutRequest aboutRequest) {
        About about = aboutMapper.toEntity(aboutRequest);
        about = aboutRepository.save(about);
        return aboutMapper.toResponse(about);
    }

    public AboutResponse getAbout(Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("About section with given id not found"));
        return aboutMapper.toResponse(about);
    }

    public AboutResponse updateAbout(Long id, AboutRequest aboutRequest) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("About section with given id not found"));
        aboutMapper.updateEntityFromRequest(aboutRequest, about);
        about = aboutRepository.save(about);
        return aboutMapper.toResponse(about);
    }

    public void deleteAbout(Long id) {
        if (!aboutRepository.existsById(id)) {
            throw new EntityNotFoundException("About section with given id not found");
        }
        aboutRepository.deleteById(id);
    }
}
