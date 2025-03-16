package pl.cieszk.portfolio.features.project.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cieszk.portfolio.features.project.mapper.ProjectMapper;
import pl.cieszk.portfolio.features.project.model.Project;
import pl.cieszk.portfolio.features.project.model.Technology;
import pl.cieszk.portfolio.features.project.repository.ProjectRepository;
import pl.cieszk.portfolio.features.project.request.ProjectRequest;
import pl.cieszk.portfolio.features.project.request.TechnologyRequest;
import pl.cieszk.portfolio.features.project.response.ProjectResponse;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TechnologyService technologyService;
    private final ProjectMapper projectMapper;

    public ProjectResponse addProject(ProjectRequest projectRequest) {
        Project project = projectMapper.toEntity(projectRequest);
        project = projectRepository.save(project);
        return projectMapper.toResponse(project);
    }

    public ProjectResponse addTechnologyToProject(Set<TechnologyRequest> technologyRequest, Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project with given id not found"));
        Set<Technology> technologies = technologyRequest.stream()
                        .map(technology -> technologyService.getTechnologyEntityByName(technology.getName()))
                        .collect(Collectors.toSet());
        project.getTechnologies().addAll(technologies);
        project = projectRepository.save(project);
        return projectMapper.toResponse(project);
    }

    public List<ProjectResponse> getAllProjects() {
        return projectMapper.toResponseList(projectRepository.findAllWithRelationships());
    }

    public ProjectResponse getProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project with given id not found"));
        return projectMapper.toResponse(project);
    }

    public ProjectResponse updateProject(ProjectRequest projectRequest, Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project with given id not found"));
        projectMapper.updateEntityFromRequest(projectRequest, project);
        project = projectRepository.save(project);
        return projectMapper.toResponse(project);
    }

    public void deleteProject(Long id) {
        if(!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project with given id not found");
        }
        projectRepository.deleteById(id);
    }
}
