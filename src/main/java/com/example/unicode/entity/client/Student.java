package com.example.unicode.entity.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="students")
public class Student {

    @Getter
    @Id
    @Column(name="user-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Setter
    @Getter
    @Column(name="BITS ID", nullable = false)
    private String bitsID;

    @Setter
    @Getter
    @Column(name="Name", nullable = false)
    private String name;

    public Student(String bitsId, String name) {
        this.bitsID = bitsId;
        this.name = name;
    }

    public Student() {

    }
}
