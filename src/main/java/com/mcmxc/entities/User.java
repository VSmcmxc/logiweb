package com.mcmxc.entities;


import com.mcmxc.entities.enums.UserRole;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "user_name", nullable = false, length = 255, unique = true)
    private String userName;

    @Basic
    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "user_role", nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "driverUser", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Driver driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
}

