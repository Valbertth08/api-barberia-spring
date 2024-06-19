package com.barbearia.api.controller;


import com.barbearia.api.entites.user.*;
import com.barbearia.api.repository.UserRepository;
import com.barbearia.api.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DataUserLoginDTO dados){
        var usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(dados.login(),dados.password());
        var auth= this.manager.authenticate(usernamePasswordAuthenticationToken);
        var toke= service.gerarToken((User)auth.getPrincipal());
        return ResponseEntity.ok(new DataUserTokenDTO(toke));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid DataUserRegisterDTO data, UriComponentsBuilder builder){
        if(this.repository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        var usuario= repository.save(new User(data.login(),encryptedPassword,data.role()));
        var uri= builder.path("/auth/register/{id}").buildAndExpand(usuario.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserListDTO>> listUser() {
        List<UserListDTO> listUser = repository.findAll().stream().map(UserListDTO::new).toList();
        return ResponseEntity.ok().body(listUser);
    }
}
