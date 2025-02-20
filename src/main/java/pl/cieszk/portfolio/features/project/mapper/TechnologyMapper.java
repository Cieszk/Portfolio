package pl.cieszk.portfolio.features.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.cieszk.portfolio.features.project.model.Technology;
import pl.cieszk.portfolio.features.project.request.TechnologyRequest;
import pl.cieszk.portfolio.features.project.response.TechnologyResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    Technology toEntity(TechnologyRequest technologyRequest);

    TechnologyResponse toResponse(Technology technology);

    List<TechnologyResponse> toResponseList(List<Technology> technologies);

    void updateEntityFromRequest(TechnologyRequest technologyRequest, @MappingTarget Technology technology);
}
