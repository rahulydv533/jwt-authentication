package com.jwt.jwtauthenticationserver.entity;

import com.jwt.jwtauthenticationserver.config.EncryptData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String email;
    @Column(nullable = false)
    private String role;
    private Double salary;
    @Convert(converter = EncryptData.class)
    private String password;
}
