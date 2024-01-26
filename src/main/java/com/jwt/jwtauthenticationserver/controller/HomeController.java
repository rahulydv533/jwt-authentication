package com.jwt.jwtauthenticationserver.controller;

import com.jwt.jwtauthenticationserver.model.User;
import com.jwt.jwtauthenticationserver.repo.EmployeeRepository;
import com.jwt.jwtauthenticationserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    //Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserService userService;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/users")
    /*
       Save in database without any prefix , EG: "READ"
     **/
    @PreAuthorize("hasAuthority('READ')")
    /*
       Save in database with prefix ROLE_, EG: In DB it should be - ROLE_ADMIN
     **/
    //@PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers() {
        var c = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("This is working");
        return userService.getUsers();
    }


}