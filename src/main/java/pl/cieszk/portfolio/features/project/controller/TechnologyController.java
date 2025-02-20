package pl.cieszk.portfolio.features.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cieszk.portfolio.core.exception.custom.ResourceAlreadyExistsException;
import pl.cieszk.portfolio.features.project.request.TechnologyRequest;
import pl.cieszk.portfolio.features.project.response.TechnologyResponse;
import pl.cieszk.portfolio.features.project.service.TechnologyService;

@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {
    private final TechnologyService technologyService;

    @GetMapping("/{id}")
    ResponseEntity<TechnologyResponse> getTechnology(@PathVariable Long id) {
        TechnologyResponse technology = technologyService.getTechnology(id);
        return ResponseEntity.ok(technology);
    }

    @PostMapping
    ResponseEntity<TechnologyResponse> createTechnology(@RequestBody TechnologyRequest technologyRequest) throws ResourceAlreadyExistsException {
        TechnologyResponse technology = technologyService.addTechnology(technologyRequest);
        return ResponseEntity.ok(technology);
    }

    @PutMapping("/{id}")
    ResponseEntity<TechnologyResponse> updateTechnology(@PathVariable Long id, @RequestBody TechnologyRequest technologyRequest) {
        TechnologyResponse technology = technologyService.updateTechnology(id, technologyRequest);
        return ResponseEntity.ok(technology);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}
