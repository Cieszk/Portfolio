package pl.cieszk.portfolio.features.about.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.cieszk.portfolio.features.about.model.Experience;
import pl.cieszk.portfolio.features.about.request.ExperienceRequest;
import pl.cieszk.portfolio.features.about.response.ExperienceResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    Experience toEntity(ExperienceRequest experienceRequest);

    ExperienceResponse toResponse(Experience experience);

    List<ExperienceResponse> toResponseList(List<Experience> experiences);

    void updateEntityFromRequest(@MappingTarget Experience experience, ExperienceRequest experienceRequest);
}
