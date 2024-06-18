package com.security.login.controller;


import com.security.login.entites.Usuario;
import com.security.login.entites.dto.InserirDto;
import com.security.login.entites.dto.LoginDto;
import com.security.login.entites.dto.RepostaDto;
import com.security.login.repository.UsuarioRepository;
import com.security.login.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping("/login")
    public ResponseEntity teste(@RequestBody @Valid LoginDto dados){
        var usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var auth= this.manager.authenticate(usernamePasswordAuthenticationToken);
        var toke= service.gerarToken((Usuario)auth.getPrincipal());
        return ResponseEntity.ok(new RepostaDto(toke));
    }
    @PostMapping("/register")
    public ResponseEntity inserir(@RequestBody @Valid InserirDto data, UriComponentsBuilder builder){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        var usuario= repository.save(new Usuario(data.login(),encryptedPassword,data.role()));
        var uri= builder.path("/auth/register/{id}").buildAndExpand(usuario.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
}
