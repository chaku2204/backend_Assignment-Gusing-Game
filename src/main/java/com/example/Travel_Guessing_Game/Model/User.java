package com.example.Travel_Guessing_Game.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // Ensures unique username
    private String username;

    @Column(nullable = false, unique = true) // Ensures unique email
    private String email;

    @Column(nullable = false)
    private String password;
}
