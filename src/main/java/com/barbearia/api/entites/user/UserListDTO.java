package com.barbearia.api.entites.user;

import com.barbearia.api.entites.user.enums.UserRole;

public record UserListDTO(Long id, String login, String password, UserRole role) {
    public UserListDTO(User user){
        this(user.getId(),user.getLogin(),user.getPassword(),user.getRole());
    }
}
