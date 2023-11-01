package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class controller {

    @GetMapping("/hello")
    public ResponseEntity<String> homepage(){
        return ResponseEntity.ok("hello");
    }
}
