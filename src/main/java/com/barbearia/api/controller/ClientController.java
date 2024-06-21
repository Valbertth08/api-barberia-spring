package com.barbearia.api.controller;


import com.barbearia.api.entites.client.Client;
import com.barbearia.api.entites.client.DataClientRegisterDTO;
import com.barbearia.api.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository repository;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid DataClientRegisterDTO data, UriComponentsBuilder builder){
        if(repository.findByLogin(data.login())!= null){
            return ResponseEntity.badRequest().build();
        }
        String passawordencode= new BCryptPasswordEncoder().encode(data.password());
        var client= repository.save(new Client(data.login(),passawordencode,data.role(),data.telphone()));
        var uri=builder.path("/register/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
