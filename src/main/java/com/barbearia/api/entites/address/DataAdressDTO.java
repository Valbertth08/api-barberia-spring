package com.barbearia.api.entites.address;

import jakarta.validation.constraints.NotBlank;

public record DataAdressDTO(
        @NotBlank
        String neighborhood,
        @NotBlank
        String cep,
        @NotBlank
        String number,
        @NotBlank
        String complement,
        @NotBlank
        String city
) {
}
