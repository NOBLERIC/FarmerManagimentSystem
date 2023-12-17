package com.farmermanagimentsystem.Repository.Modal;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "sign_up")
@Data
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
}

