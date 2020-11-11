package com.example.heroku.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> userEntities;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }
}

