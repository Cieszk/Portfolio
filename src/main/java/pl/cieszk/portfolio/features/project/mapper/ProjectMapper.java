package pl.cieszk.portfolio.features.project.mapper;

import org.hibernate.Hibernate;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.cieszk.portfolio.features.project.model.Media;
import pl.cieszk.portfolio.features.project.model.Project;
import pl.cieszk.portfolio.features.project.model.Technology;
import pl.cieszk.portfolio.features.project.request.ProjectRequest;
import pl.cieszk.portfolio.features.project.response.MediaResponse;
import pl.cieszk.portfolio.features.project.response.ProjectResponse;
import pl.cieszk.portfolio.features.project.response.TechnologyResponse;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toEntity(ProjectRequest projectRequest);

    @Mapping(source = "technologies", target = "technologies")
    @Mapping(source = "screenshots", target = "screenshots")
    ProjectResponse toResponse(Project project);

    MediaResponse toMediaResponse(Media media);

    TechnologyResponse toTechnologyResponse(Technology technology);

    @Mapping(source = "technologies", target = "technologies")
    @Mapping(source = "screenshots", target = "screenshots")
    List<ProjectResponse> toResponseList(List<Project> projects);

    void updateEntityFromRequest(ProjectRequest projectRequest, @MappingTarget Project project);

    Set<MediaResponse> toMediaResponses(Set<Media> media);

    default Set<TechnologyResponse> toTechnologyResponses(Set<Technology> technologies) {
        if (technologies == null) {
            return Collections.emptySet();
        }

        // Safely copy elements without triggering ConcurrentModificationException
        List<Technology> tempList = new ArrayList<>(technologies.size());
        for (Technology t : technologies) {
            tempList.add(t);
        }
        return tempList.stream()
                .map(this::toTechnologyResponse)
                .collect(Collectors.toSet());
    }
}