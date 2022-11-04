package com.ecommerce.ecommerceapi.User;

import javax.persistence.*;

@Entity(name = "userEntity")
@Table(name = "users")
public class UserEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    private String errorMessage;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public UserEntity() {
    }

    public UserEntity(String errorMessage, Long id) {
        this.errorMessage = errorMessage;
        this.id = id;
    }

    public UserEntity(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserEntity(String name, String lastName, String email, String password, long id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
