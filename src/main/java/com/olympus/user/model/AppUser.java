package com.olympus.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.olympus.user.Enum.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "username", nullable = false , unique = true , length = 50)
    private String UserName;

    @Column(name = "firstname", nullable = false, length = 50)
    private String FirstName;

    @Column(name = "lastname", nullable = false , length = 50)
    private String LastName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String Email;

    @Column(name = "phonenumber", nullable = false, unique = true , length = 30)
    private String PhoneNumber;

    @Column(name = "Gender", nullable = false, length = 6 )
    private Gender Gender;

    @Column(name = "avatar_key")
    private String AvatarKey;

    @Column(name = "password", nullable = false,length = 100 )
    private String Password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime CreatedAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime UpdatedAt;

    @Column(name = "birth_date", nullable = false)
    private LocalDate BrithDate;


    @PrePersist
    protected void onCreate() 
    {
        this.CreatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate()
    {
        this.UpdatedAt = LocalDateTime.now();
    }
}
