package ru.aigul.testProject.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Aigul on 07.12.2016.
 * Сущность User
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Roles role;

    public User(String name, String password, Roles role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    /**
     * Метод получения id пользователя
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * Метод присвоения id пользователя
     * @param id long
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Метод получения name пользователя
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Метод присвоения name пользователя
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод получения password пользователя
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод присвоения password пользователя
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Метод получения role пользователя
     * @return Roles
     */
    public Roles getRole() {
        return role;
    }

    /**
     * Метод присвоения role пользователя
     * @param role Roles
     */
    public void setRole(Roles role) {
        this.role = role;
    }

    /**
     * Метод возвращающий User типа String
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


