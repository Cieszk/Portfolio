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
public class EducationRequest {
    private String institution;
    private String fieldOfStudy;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long aboutId;
}
