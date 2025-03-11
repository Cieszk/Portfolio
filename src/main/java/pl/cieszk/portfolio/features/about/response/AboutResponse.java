package pl.cieszk.portfolio.features.about.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutResponse {
    private Long id;
    private String bio;
    private String avatarUrl;
    private String resumeUrl;
    private Map<String, String> socialLinks;
    private List<ExperienceResponse> experiences;
    private List<EducationResponse> educations;
}
