package pl.cieszk.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PasswordEncoderTest {

    // Initialize them right away
    private String rawPassword = "PiesKot69!";
    private String storedHash  = "$2a$10$2CvOps7mW7J.4y4X8dTfEeGQ7g5E.1o8t1WpUZkz7Jv6n5YbL1DmK";

    @Test
    public void testPasswordMatches() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean matches = encoder.matches(rawPassword, storedHash);
        assertFalse(matches, "Password should not match");
    }
}

