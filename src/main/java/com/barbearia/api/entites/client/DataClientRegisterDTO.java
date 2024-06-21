package com.barbearia.api.entites.client;

import com.barbearia.api.entites.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record   DataClientRegisterDTO(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotNull
        UserRole role,
        @NotNull
        Long telphone
) {
}
