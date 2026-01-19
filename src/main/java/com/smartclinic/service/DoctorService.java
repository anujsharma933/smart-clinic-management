@Service
public class DoctorService {

    public List<LocalTime> getAvailableSlots(Long doctorId, LocalDate date) {
        return List.of();
    }

    public ResponseEntity<?> login(String email, String password) {
        return ResponseEntity.ok("Success");
    }
}
