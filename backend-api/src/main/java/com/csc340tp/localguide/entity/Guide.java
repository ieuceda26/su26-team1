package com.csc340tp.localguide.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guide")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String keyword;

    @OneToMany(mappedBy = "guide", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TourListings> listings;


    public Guide(String name, String email, String password, String keyword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.keyword = keyword;
    }

}
