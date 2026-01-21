import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@PostMapping("/prescriptions/{token}")
public ResponseEntity<Map<String, String>> savePrescription(
        @PathVariable String token,
        @Valid @RequestBody Prescription prescription) {

    Map<String, String> response = new HashMap<>();

    // Basic token validation
    if (token == null || token.isBlank()) {
        response.put("status", "error");
        response.put("message", "Invalid token");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // Simulated save logic
    response.put("status", "success");
    response.put("message", "Prescription saved successfully");

    return ResponseEntity.ok(response);
}
