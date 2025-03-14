package pl.cieszk.portfolio.features.about.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cieszk.portfolio.features.about.mapper.EducationMapper;
import pl.cieszk.portfolio.features.about.model.About;
import pl.cieszk.portfolio.features.about.model.Education;
import pl.cieszk.portfolio.features.about.repository.AboutRepository;
import pl.cieszk.portfolio.features.about.repository.EducationRepository;
import pl.cieszk.portfolio.features.about.request.EducationRequest;
import pl.cieszk.portfolio.features.about.response.EducationResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository educationRepository;
    private final AboutRepository aboutRepository;
    private final EducationMapper educationMapper;

    public EducationResponse addEducation(EducationRequest educationRequest) {
        About about = aboutRepository.findById(educationRequest.getAboutId())
                .orElseThrow(() -> new EntityNotFoundException("About section with given id not found"));
        Education education = educationMapper.toEntity(educationRequest);
        education.setAbout(about);
        education = educationRepository.save(education);
        return educationMapper.toResponse(education);
    }

    public EducationResponse getEducation(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education with given id not found"));
        return educationMapper.toResponse(education);
    }

    public List<EducationResponse> getEducationList() {
        List<Education> educations = educationRepository.findAll();
        return educationMapper.toResponseList(educations);
    }

    public EducationResponse updateEducation(EducationRequest educationRequest, Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education with given id not found"));
        educationMapper.updateEntityFromRequest(education, educationRequest);
        education = educationRepository.save(education);
        return educationMapper.toResponse(education);
    }

    public void deleteEducation(Long id) {
        if (!educationRepository.existsById(id)) {
            throw new EntityNotFoundException("Education with given id not found");
        }
        educationRepository.deleteById(id);
    }
}
