package com.jwt.jwtauthenticationserver.repo;

import com.jwt.jwtauthenticationserver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByName(String username);
}
