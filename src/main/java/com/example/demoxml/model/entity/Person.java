package com.example.demoxml.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Entity
@Table(name = "tb_persons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50)
    String firstName;

    @Column(length = 50)
    String lastName;

    @Column(length = 50)
    String patronymic;

    @Column(unique = true)
    Long account;
}
