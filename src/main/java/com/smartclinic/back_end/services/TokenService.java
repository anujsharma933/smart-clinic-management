@Service
public class TokenService {

    private final String SECRET = "secretkey";

    public String generateToken(String email) {
        return Jwts.builder().setSubject(email).signWith(getKey()).compact();
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}
