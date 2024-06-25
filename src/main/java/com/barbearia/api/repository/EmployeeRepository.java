package com.barbearia.api.repository;

import com.barbearia.api.entites.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    UserDetails findByLogin(String login);
}
