package pl.cieszk.portfolio.features.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pl.cieszk.portfolio.features.project.model.Media;
import pl.cieszk.portfolio.features.project.request.MediaRequest;
import pl.cieszk.portfolio.features.project.response.MediaResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MediaMapper {
    MediaResponse toResponse(Media media);
    @Mapping(target = "project", ignore = true)
    Media toEntity(MediaRequest mediaRequest);

    List<MediaResponse> toResponseList(List<Media> mediaList);

    void updateEntityFromRequest(MediaRequest mediaRequest, @MappingTarget Media media);

}
