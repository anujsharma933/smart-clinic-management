package com.smartclinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @GetMapping("/{id}/availability")
    public ResponseEntity<?> getAvailability(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id) {
        return ResponseEntity.ok(Map.of("status", "success"));
    }
}

