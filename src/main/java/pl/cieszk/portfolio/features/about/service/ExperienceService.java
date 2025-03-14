package pl.cieszk.portfolio.features.about.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.cieszk.portfolio.features.about.mapper.ExperienceMapper;
import pl.cieszk.portfolio.features.about.model.About;
import pl.cieszk.portfolio.features.about.model.Experience;
import pl.cieszk.portfolio.features.about.repository.AboutRepository;
import pl.cieszk.portfolio.features.about.repository.ExperienceRepository;
import pl.cieszk.portfolio.features.about.request.ExperienceRequest;
import pl.cieszk.portfolio.features.about.response.ExperienceResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final AboutRepository aboutRepository;
    private final ExperienceMapper experienceMapper;

    public ExperienceResponse addExperience(ExperienceRequest experienceRequest) {
        About about = aboutRepository.findById(experienceRequest.getAboutId())
                .orElseThrow(() -> new EntityNotFoundException("About with given id not found"));
        Experience experience = experienceMapper.toEntity(experienceRequest);
        experience.setAbout(about);
        experience = experienceRepository.save(experience);
        return experienceMapper.toResponse(experience);
    }

    public ExperienceResponse getExperience(Long id) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Experience with given id not found"));
        return experienceMapper.toResponse(experience);
    }

    public List<ExperienceResponse> getAllExperience() {
        List<Experience> experiences = experienceRepository.findAll();
        return experienceMapper.toResponseList(experiences);
    }

    public ExperienceResponse updateExperience(ExperienceRequest experienceRequest, Long id) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Experience with given id not found"));
        experienceMapper.updateEntityFromRequest(experience, experienceRequest);
        experience = experienceRepository.save(experience);
        return experienceMapper.toResponse(experience);
    }

    public void deleteExperience(Long id) {
        if (!experienceRepository.existsById(id)) {
            throw new EntityNotFoundException("Experience with given id not found");
        }
        experienceRepository.deleteById(id);
    }
}
