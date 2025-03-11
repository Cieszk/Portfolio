package pl.cieszk.portfolio.features.about.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cieszk.portfolio.features.about.request.AboutRequest;
import pl.cieszk.portfolio.features.about.response.AboutResponse;
import pl.cieszk.portfolio.features.about.service.AboutService;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;

    @GetMapping("/{id}")
    ResponseEntity<AboutResponse> getAboutSection(@PathVariable Long id) {
        AboutResponse about = aboutService.getAbout(id);
        return ResponseEntity.ok(about);
    }

    @PostMapping
    ResponseEntity<AboutResponse> createAboutSection(@RequestBody AboutRequest aboutRequest) {
        AboutResponse about = aboutService.addAbout(aboutRequest);
        return ResponseEntity.ok(about);
    }

    @PutMapping("/{id}")
    ResponseEntity<AboutResponse> updateAboutSection(@PathVariable Long id,@RequestBody AboutRequest aboutRequest) {
        AboutResponse about = aboutService.updateAbout(id, aboutRequest);
        return ResponseEntity.ok(about);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAboutSection(@PathVariable Long id) {
        aboutService.deleteAbout(id);
        return ResponseEntity.noContent().build();
    }
}
