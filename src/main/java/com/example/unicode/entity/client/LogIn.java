package com.example.unicode.entity.client;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="login")
public class LogIn {
    
    @Getter
    @Id
    @Column(name="user-id", nullable = false)
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

    // just because it can be Alpha Numeric
    @Getter
    @Setter
    @Column(name="Lab Number", nullable = false)
    private String labNumber;

    @Getter
    @Setter
    @Column(name="System Number", nullable = false)
    private int systemNumber;

    @Getter
    @Setter
    @Column(name="IP Address", nullable = false)
    private String ipAddress;

    @Getter
    @Setter
    @CreationTimestamp
    @Column(name = "Log In Time", updatable = false, nullable = false)
    private LocalDateTime logInTime;

    @Getter
    @Setter
    @Column(name="Token")
    private String hashedToken;
}
