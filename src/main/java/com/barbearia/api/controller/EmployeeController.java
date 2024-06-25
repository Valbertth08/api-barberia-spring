package com.barbearia.api.controller;


import com.barbearia.api.entites.employee.DataEmployeeRegisterDTO;
import com.barbearia.api.entites.employee.Employee;
import com.barbearia.api.repository.EmployeeRepository;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid DataEmployeeRegisterDTO data, UriComponentsBuilder builder){
        if(repository.findByLogin(data.login())!=null){
            return ResponseEntity.badRequest().build();
        }
        String passawordencode= new BCryptPasswordEncoder().encode(data.password());
        var usuario=repository.save(new Employee(data.login(),passawordencode,data.role(),data.specialty(),data.adress()));
        var uri= builder.path("/register/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
