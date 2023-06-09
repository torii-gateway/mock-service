package org.torii.gateway.mockservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping
    public ResponseEntity echo() {
        return ResponseEntity.ok().header("X-Test-Header", "test").build();
    }
}
