package siakad_api.controller;

import org.springframework.web.bind.annotation.*;

import siakad_api.dto.LoginRequest;
import siakad_api.utils.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("api/auth/")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest req) {
        if (req.getUsername().equals("admin") && req.getPassword().equals("123")) {
            String token = JwtUtil.generateToken(req.getUsername());

            return Map.of("token", token);
        }
        throw new RuntimeException("Invalid login");
    }
}
