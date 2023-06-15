package org.torii.gateway.mockservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity echo() {
        //delays the response by .4 seconds

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().header("X-instance-name", environment.getProperty("instance.name")).build();
    }
}
