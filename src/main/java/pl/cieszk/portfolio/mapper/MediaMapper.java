package pl.cieszk.portfolio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pl.cieszk.portfolio.model.Media;
import pl.cieszk.portfolio.model.Project;
import pl.cieszk.portfolio.request.MediaRequest;
import pl.cieszk.portfolio.response.MediaResponse;
import pl.cieszk.portfolio.response.ProjectResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MediaMapper {
    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);
    MediaResponse toResponse(Media media);
    @Mapping(target = "project", ignore = true)
    Media toEntity(MediaRequest mediaRequest);

    List<MediaResponse> toResponseList(List<Media> mediaList);

    void updateEntityFromRequest(MediaRequest mediaRequest, @MappingTarget Media media);

}
