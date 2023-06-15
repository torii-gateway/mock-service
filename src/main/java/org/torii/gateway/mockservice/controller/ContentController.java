package org.torii.gateway.mockservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.torii.gateway.mockservice.domain.Content;
import org.torii.gateway.mockservice.rest.requests.CreateContentRequest;
import org.torii.gateway.mockservice.rest.requests.UpdateContentRequest;
import org.torii.gateway.mockservice.service.ContentService;

import java.util.List;
import java.util.Optional;

import static java.net.URI.*;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
@Slf4j
public class ContentController {

    private final ContentService contentService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Content>> getAllContent() {
        //delay of 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(contentService.getAllContent());
    }

    @PostMapping
    public ResponseEntity<Long> createContent(@Valid @RequestBody CreateContentRequest createContentRequest) {
        log.info("create content request: {}", createContentRequest.getData());
        var uri = "/mock/" + contentService.createContent(createContentRequest);
        return ResponseEntity.created(create(uri)).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody UpdateContentRequest updateContentRequest) {
        if (!id.equals(updateContentRequest.getId())) throw new RuntimeException("id mismatch");
        contentService.updateContent(updateContentRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Content>> getContent(@PathVariable Long id) {
        Optional<Content> content = contentService.getContent(id);

        if (content.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(content);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Content> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.accepted().build();
    }
}
