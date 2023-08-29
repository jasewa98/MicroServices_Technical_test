package com.jorgeseoane.mercadona.mercadona.controller.auth;

import com.jorgeseoane.mercadona.mercadona.model.auth.AuthResponse;
import com.jorgeseoane.mercadona.mercadona.model.auth.LoginRequest;
import com.jorgeseoane.mercadona.mercadona.model.auth.RegisterRequest;
import com.jorgeseoane.mercadona.mercadona.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
