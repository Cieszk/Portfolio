package pl.cieszk.portfolio.features.about.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationResponse {
    private String institution;
    private String fieldOfStudy;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
