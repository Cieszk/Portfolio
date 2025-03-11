package pl.cieszk.portfolio.features.about.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.cieszk.portfolio.features.about.model.Experience;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutRequest {
    private String bio;
    private String avatarUrl;
    private String resumeUrl;
    private Map<String, String> socialLinks;
}
