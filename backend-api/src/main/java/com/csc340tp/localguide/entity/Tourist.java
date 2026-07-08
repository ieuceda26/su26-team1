package com.csc340tp.localguide.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tourists")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long touristId;

    private String name;
    private String email;
    private String password;

    public Tourist() {}

    public Tourist(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getTouristId() { return touristId; }
    public void setTouristId(Long touristId) { this.touristId = touristId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
