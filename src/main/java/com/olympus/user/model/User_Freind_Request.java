package com.olympus.user.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Table(
    name = "user_friend_request",
    indexes = 
    {
        @Index(name = "usr_friend_request", columnList = "user_id")
    }
)
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class User_Freind_Request {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requester_id", nullable = false)
    private AppUser requester;

    @Column (name = "createdAt", nullable=false)
    private LocalDateTime createdAt;

    @PrePersist 
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
    }


    
}
