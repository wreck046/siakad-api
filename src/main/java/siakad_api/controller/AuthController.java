package siakad_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/auth/")
@CrossOrigin(origins = "*")
public class AuthController {

   @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if ("admin".equals(username) && "123".equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("token", "dummy-token-123");
            response.put("username", username);
            return response;
        } else {
            throw new RuntimeException("Username atau password salah");
        }
    }
}
