package com.barbearia.api.entites.employee;


import com.barbearia.api.entites.address.Address;
import com.barbearia.api.entites.address.DataAdressDTO;
import com.barbearia.api.entites.employee.enums.Specialty;
import com.barbearia.api.entites.user.User;
import com.barbearia.api.entites.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "tb_employee")
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee  extends User {
    @Enumerated(value = EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;

    public Employee(String login, String password, UserRole role, Specialty specialty, DataAdressDTO dataAdress) {
        super(login, password, role);
        this.specialty = specialty;
        this.address = new Address(dataAdress);
    }

}
