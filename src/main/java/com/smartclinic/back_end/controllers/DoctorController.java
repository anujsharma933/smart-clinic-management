package com.smartclinic.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DoctorController {

    /**
     * URL Pattern:
     * /api/{user}/doctor/{doctorId}/availability?date=YYYY-MM-DD
     */
    @GetMapping("/{user}/doctor/{doctorId}/availability")
    public ResponseEntity<Map<String, Object>> getDoctorAvailability(
            @RequestHeader("Authorization") String token,
            @PathVariable String user,
            @PathVariable Long doctorId,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {

        // 🔐 Basic token validation
        if (token == null || !token.startsWith("Bearer ")) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Invalid or missing token");
            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
        }

        // ✅ Structured success response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("user", user);
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("availableTimes", new String[]{
                "09:00", "10:00", "11:30", "14:00"
        });

        return ResponseEntity.ok(response);
    }
}
