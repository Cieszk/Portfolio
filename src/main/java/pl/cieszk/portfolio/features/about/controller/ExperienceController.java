package pl.cieszk.portfolio.features.about.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cieszk.portfolio.features.about.request.ExperienceRequest;
import pl.cieszk.portfolio.features.about.response.ExperienceResponse;
import pl.cieszk.portfolio.features.about.service.ExperienceService;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @PostMapping
    ResponseEntity<ExperienceResponse> createExperienceSection(ExperienceRequest experienceRequest) {
        ExperienceResponse experience = experienceService.addExperience(experienceRequest);
        return ResponseEntity.ok(experience);
    }

    @GetMapping("/{id}")
    ResponseEntity<ExperienceResponse> getExperience(@PathVariable Long id) {
        ExperienceResponse experience = experienceService.getExperience(id);
        return ResponseEntity.ok(experience);
    }

    @GetMapping
    ResponseEntity<List<ExperienceResponse>> getAllExperience() {
        List<ExperienceResponse> experiences = experienceService.getAllExperience();
        return ResponseEntity.ok(experiences);
    }

    @PutMapping("/{id}")
    ResponseEntity<ExperienceResponse> updateExperience(@RequestBody ExperienceRequest experienceRequest, @PathVariable Long id) {
        ExperienceResponse experience = experienceService.updateExperience(experienceRequest, id);
        return ResponseEntity.ok(experience);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return ResponseEntity.noContent().build();
    }
}
