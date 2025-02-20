package pl.cieszk.portfolio.features.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.cieszk.portfolio.core.exception.custom.ResourceAlreadyExistsException;
import pl.cieszk.portfolio.features.project.request.MediaRequest;
import pl.cieszk.portfolio.features.project.response.MediaResponse;
import pl.cieszk.portfolio.features.project.service.MediaService;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;

    @GetMapping("/{id}")
    ResponseEntity<MediaResponse> getMediaById(@PathVariable Long id) {
        MediaResponse media = mediaService.getMedia(id);
        return ResponseEntity.ok(media);
    }

    @PostMapping
    ResponseEntity<MediaResponse> createMedia(@RequestBody MediaRequest mediaRequest) throws ResourceAlreadyExistsException {
        MediaResponse media = mediaService.addMedia(mediaRequest);
        return ResponseEntity.ok(media);
    }

    @PutMapping("/{id}")
    ResponseEntity<MediaResponse> updateMedia(@PathVariable Long id, @RequestBody MediaRequest mediaRequest) {
        MediaResponse media = mediaService.updateMedia(mediaRequest, id);
        return ResponseEntity.ok(media);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }
}
