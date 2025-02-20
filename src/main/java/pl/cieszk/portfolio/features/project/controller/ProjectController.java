package pl.cieszk.portfolio.features.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cieszk.portfolio.features.project.request.ProjectRequest;
import pl.cieszk.portfolio.features.project.request.TechnologyRequest;
import pl.cieszk.portfolio.features.project.response.ProjectResponse;
import pl.cieszk.portfolio.features.project.service.ProjectService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse project = projectService.addProject(projectRequest);
        return ResponseEntity.ok(project);
    }

    @PostMapping("/{id}/technology/add")
    ResponseEntity<ProjectResponse> addTechnologyToProject(@RequestBody Set<TechnologyRequest> technologyRequest, @PathVariable Long id) {
        ProjectResponse project = projectService.addTechnologyToProject(technologyRequest, id);
        return ResponseEntity.ok(project);
    }

    @GetMapping
    ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    ResponseEntity<ProjectResponse> getProject(@PathVariable Long id) {
        ProjectResponse project = projectService.getProject(id);
        return ResponseEntity.ok(project);
    }

    @PutMapping("/{id}")
    ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody ProjectRequest projectRequest) {
        ProjectResponse project = projectService.updateProject(projectRequest, id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
