package pl.cieszk.portfolio.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaResponse {
    private Long id;
    private String url;
    private String mediaType;
}
