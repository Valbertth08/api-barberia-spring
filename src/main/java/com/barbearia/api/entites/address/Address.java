package com.barbearia.api.entites.address;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {
    @NotBlank
    private String neighborhood;
    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;
    @NotBlank
    private String number;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    public Address(DataAdressDTO adress) {
        this.neighborhood= adress.neighborhood();
        this.cep=adress.cep();
        this.city=adress.city();
        this.number=adress.number();
        this.complement= adress.complement();
    }
}
