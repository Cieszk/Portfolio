package pl.cieszk.portfolio.features.project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaRequest {
    private String url;
    private String mediaType;
    private Long project_id;
}
