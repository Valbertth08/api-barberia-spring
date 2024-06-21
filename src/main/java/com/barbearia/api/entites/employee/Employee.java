package com.barbearia.api.entites.employee;


import com.barbearia.api.entites.address.Address;
import com.barbearia.api.entites.employee.enums.Specialty;
import com.barbearia.api.entites.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_employee")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee  extends User {
    @Enumerated(value = EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;
}
