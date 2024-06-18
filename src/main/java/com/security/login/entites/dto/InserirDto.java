package com.security.login.entites.dto;

import com.security.login.entites.Enum.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InserirDto(

        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotNull
        UserRole role
) {
}
