package ru.aigul.testProject.entity;

/**
 * Created by Aigul on 07.12.2016.
 * Enum пользовательских ролей
 */
public enum Roles {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_ANONYMOUS("ROLE_ANONYMOUS");

    private String role;

    /**
     * Конструктор Roles
     * @param role String
     */
    private Roles(final String role) {
        this.role = role;
    }

    /**
     * Метод возвращающий Role типа String
     * @return String
     */
    @Override
    public String toString() {
        return role;
    }
}