package pl.cieszk.portfolio.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {
    private Long id;
    private String title;
    private String slug;
    private String description;
    private String shortDescription;
    private String githubUrl;
    private String demoUrl;
    private LocalDate startDate;
    private boolean isFeatured;
    private Set<TechnologyResponse> technologies;
    private List<MediaResponse> screenshots;
}
