package com.barbearia.api.entites.user;

import com.barbearia.api.entites.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUserRegisterDTO(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotNull
        UserRole role
) {
}
