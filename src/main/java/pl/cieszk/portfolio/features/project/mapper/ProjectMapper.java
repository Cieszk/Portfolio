package pl.cieszk.portfolio.features.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pl.cieszk.portfolio.features.project.model.Project;
import pl.cieszk.portfolio.features.project.request.ProjectRequest;
import pl.cieszk.portfolio.features.project.response.ProjectResponse;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TechnologyMapper.class, MediaMapper.class})
public interface ProjectMapper {
    Project toEntity(ProjectRequest projectRequest);

    @Mapping(source = "technologies", target = "technologies")
    @Mapping(source = "screenshots", target = "screenshots")
    ProjectResponse toResponse(Project project);

    @Mapping(source = "technologies", target = "technologies")
    @Mapping(source = "screenshots", target = "screenshots")
    List<ProjectResponse> toResponseList(List<Project> all);

    void updateEntityFromRequest(ProjectRequest projectRequest, @MappingTarget Project project);
}
