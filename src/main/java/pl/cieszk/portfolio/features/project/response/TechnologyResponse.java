package pl.cieszk.portfolio.features.project.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TechnologyResponse {
    private Long id;
    private String name;
    private String iconUrl;
}
