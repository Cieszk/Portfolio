package pl.cieszk.portfolio.features.about.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceRequest {
    private String company;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Long aboutId;
}
