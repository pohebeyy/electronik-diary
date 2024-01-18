package ru.dnevnik.pohebeyy.dnevnik.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Users")

public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    private String roles;

}

