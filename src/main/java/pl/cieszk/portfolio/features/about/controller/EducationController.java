package pl.cieszk.portfolio.features.about.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cieszk.portfolio.features.about.request.EducationRequest;
import pl.cieszk.portfolio.features.about.response.EducationResponse;
import pl.cieszk.portfolio.features.about.service.EducationService;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @PostMapping
    public ResponseEntity<EducationResponse> createEducationSection(@RequestBody EducationRequest educationRequest) {
        EducationResponse education = educationService.addEducation(educationRequest);
        return ResponseEntity.ok(education);
    }

    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAllEducations() {
        List<EducationResponse> educations = educationService.getEducationList();
        return ResponseEntity.ok(educations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> getEducation(@PathVariable Long id) {
        EducationResponse education = educationService.getEducation(id);
        return ResponseEntity.ok(education);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationResponse> updateEducation(@RequestBody EducationRequest educationRequest, @PathVariable Long id) {
        EducationResponse education = educationService.updateEducation(educationRequest, id);
        return ResponseEntity.ok(education);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
}