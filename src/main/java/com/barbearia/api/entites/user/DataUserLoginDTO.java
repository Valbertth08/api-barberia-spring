package com.barbearia.api.entites.user;

import jakarta.validation.constraints.NotBlank;

public record DataUserLoginDTO(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
