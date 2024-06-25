package com.barbearia.api.entites.employee;

import com.barbearia.api.entites.address.DataAdressDTO;
import com.barbearia.api.entites.employee.enums.Specialty;
import com.barbearia.api.entites.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataEmployeeRegisterDTO(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotNull
        UserRole role,
        @NotNull
        Specialty specialty,
        @NotNull
        DataAdressDTO adress
) {
}
