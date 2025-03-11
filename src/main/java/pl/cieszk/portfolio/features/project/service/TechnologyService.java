package pl.cieszk.portfolio.features.project.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cieszk.portfolio.core.exception.custom.ResourceAlreadyExistsException;
import pl.cieszk.portfolio.features.project.mapper.TechnologyMapper;
import pl.cieszk.portfolio.features.project.model.Technology;
import pl.cieszk.portfolio.features.project.repository.TechnologyRepository;
import pl.cieszk.portfolio.features.project.request.TechnologyRequest;
import pl.cieszk.portfolio.features.project.response.TechnologyResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyService {
    private final TechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;

    public TechnologyResponse addTechnology(TechnologyRequest technologyRequest) throws ResourceAlreadyExistsException {
        if (technologyRepository.existsByName(technologyRequest.getName())) {
            throw new ResourceAlreadyExistsException("Given technology already exists");
        }
        Technology technology = technologyMapper.toEntity(technologyRequest);
        technology = technologyRepository.save(technology);
        return technologyMapper.toResponse(technology);
    }

    public List<TechnologyResponse> getTechnologiesForProject(Long id) {
        List<Technology> technologies = technologyRepository.findByProjects_Id(id);
        return technologyMapper.toResponseList(technologies);
    }

    public TechnologyResponse getTechnology(Long id) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Technology with given id not found"));
        return technologyMapper.toResponse(technology);
    }

    public Technology getTechnologyEntityByName(String name) {
        return technologyRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Technology with given name not found"));
    }

    public Technology getTechnologyEntityById(Long id) {
        return technologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Technology with given name not found"));
    }

    public TechnologyResponse updateTechnology(Long id, TechnologyRequest technologyRequest) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Technology with given id not found"));
        technologyMapper.updateEntityFromRequest(technologyRequest, technology);
        technology = technologyRepository.save(technology);
        return technologyMapper.toResponse(technology);
    }

    public void deleteTechnology(Long id) {
        if (!technologyRepository.existsById(id)) {
            throw new EntityNotFoundException("Technology with given id not found");
        }
        technologyRepository.deleteById(id);
    }
}
