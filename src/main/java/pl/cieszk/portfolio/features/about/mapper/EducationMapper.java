package pl.cieszk.portfolio.features.about.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.cieszk.portfolio.features.about.model.Education;
import pl.cieszk.portfolio.features.about.request.EducationRequest;
import pl.cieszk.portfolio.features.about.response.EducationResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    Education toEntity(EducationRequest educationRequest);

    EducationResponse toResponse(Education education);

    List<EducationResponse> toResponseList(List<Education> educations);

    void updateEntityFromRequest(@MappingTarget Education education, EducationRequest educationRequest);
}
