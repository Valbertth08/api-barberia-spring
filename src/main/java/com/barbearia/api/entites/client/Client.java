package com.barbearia.api.entites.client;

import com.barbearia.api.entites.address.Address;
import com.barbearia.api.entites.user.User;
import com.barbearia.api.entites.user.enums.UserRole;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_client")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {
    private Long telephone;
    public Client(Long telephone) {
        this.telephone = telephone;
    }
    public Client(String login, String password, UserRole role, Long telephone) {
        super(login, password, role);
        this.telephone = telephone;
    }
}
