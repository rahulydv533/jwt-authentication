package com.jwt.jwtauthenticationserver.controller;

import com.jwt.jwtauthenticationserver.entity.Employee;
import com.jwt.jwtauthenticationserver.model.JWTRequest;
import com.jwt.jwtauthenticationserver.model.JWTResponse;
import com.jwt.jwtauthenticationserver.model.MyUserDetails;
import com.jwt.jwtauthenticationserver.repo.EmployeeRepository;
import com.jwt.jwtauthenticationserver.security.JwtHelper;
import com.jwt.jwtauthenticationserver.service.EmployeeDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeDetailService userDetailsService;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtHelper helper;

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());

        MyUserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JWTResponse response = JWTResponse.builder().jwtToken(token).username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public Employee registerUser(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    private void doAuthenticate(String name, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(name, password);
        try {
            /**
             Calling authenticationManager.authenticate() you get to check the credentials
             against the provider (LDAP, Database, OAUTH and etc).
             */
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
