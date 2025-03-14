package pl.cieszk.portfolio.features.about.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.cieszk.portfolio.features.about.model.About;
import pl.cieszk.portfolio.features.about.request.AboutRequest;
import pl.cieszk.portfolio.features.about.response.AboutResponse;

@Mapper(componentModel = "spring")
public interface AboutMapper {
    About toEntity(AboutRequest aboutRequest);

    AboutResponse toResponse(About about);

    void updateEntityFromRequest(AboutRequest aboutRequest, @MappingTarget About about);
}
