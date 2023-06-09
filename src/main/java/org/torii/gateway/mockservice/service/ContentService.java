package org.torii.gateway.mockservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.torii.gateway.mockservice.domain.Content;
import org.torii.gateway.mockservice.repo.ContentRepository;
import org.torii.gateway.mockservice.rest.requests.CreateContentRequest;
import org.torii.gateway.mockservice.rest.requests.UpdateContentRequest;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public Long createContent(CreateContentRequest request) {
        var content = new Content(null, request.getData());
        return contentRepository.save(content).getId();
    }

    public Optional<Content> getContent(Long id) {
        return contentRepository.findById(id);
    }

    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }

    public void updateContent(UpdateContentRequest request) {
        var content = contentRepository.findById(request.id).orElseThrow();
        content.setData(request.getContent());
        contentRepository.save(content);
    }

    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

}
