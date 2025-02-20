package pl.cieszk.portfolio.features.project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequest {
    private String title;
    private String description;
    private String shortDescription;
    private String githubUrl;
    private String demoUrl;
    private LocalDate startDate;
}
