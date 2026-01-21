@PostMapping("/prescriptions")
public ResponseEntity<?> save(
        @RequestHeader("Authorization") String token,
        @RequestBody Prescription p) {
    return ResponseEntity.ok("Saved");
}
