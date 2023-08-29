package com.jorgeseoane.mercadona.mercadona.service.auth;

import com.jorgeseoane.mercadona.mercadona.model.auth.AuthResponse;
import com.jorgeseoane.mercadona.mercadona.model.auth.LoginRequest;
import com.jorgeseoane.mercadona.mercadona.model.auth.RegisterRequest;
import com.jorgeseoane.mercadona.mercadona.model.auth.User;
import com.jorgeseoane.mercadona.mercadona.repository.auth.UserRepository;
import com.jorgeseoane.mercadona.mercadona.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).firstname(request.getFirstname()).lastname(request.getLastname()).country(request.getCountry()).role(Role.USER).build();
        userRepository.save(user);
        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }
}
