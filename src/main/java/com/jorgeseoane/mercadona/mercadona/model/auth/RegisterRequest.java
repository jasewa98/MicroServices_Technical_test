package com.jorgeseoane.mercadona.mercadona.model.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "El username no puede estar vacío")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres")
    String username;
    @NotBlank(message = "La pdw no puede estar vacío")
    String password;
    String firstname;
    String lastname;
    String country;
}
