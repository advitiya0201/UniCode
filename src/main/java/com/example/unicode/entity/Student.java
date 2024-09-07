package com.example.unicode.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="student")
public class Student {

    @Getter
    @Id
    @Column(name="user-id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(name="BITS ID", nullable = false)
    private String bitsId;

    @Setter
    @Getter
    @Column(name="Name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name="Lab Number", nullable = false)
    private int labNumber;

    @Getter
    @Setter
    @Column(name="System Number", nullable = false)
    private int systemNumber;

    @Getter
    @Setter
    @Column(name="IP Address")
    private String ipAddress;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "sign_in_time", nullable = false, updatable = false)
    private LocalDateTime signInTime;

    @Getter
    @Setter
    @Column(name="Hash Code")
    private String hashCode;

    public Student(String bitsId, int labNumber, String name, int systemNumber) {
        this.bitsId = bitsId;
        this.labNumber = labNumber;
        this.name = name;
        this.systemNumber = systemNumber;
    }

    public Student() {

    }
}
