package ru.aigul.testProject.services;

import ru.aigul.testProject.entity.User;
import ru.aigul.testProject.exception.DublicateException;

/**
 * Created by Aigul on 07.12.2016.
 * Сервис для работы с User
 */
public interface UserService {

    /**
     * Добавление нового пользователя
     * @param user User
     */
    void addUser(User user) throws DublicateException;

    /**
     * Поиск пользователя по имени
     * @param name String
     * @return User
     */
    User find(String name);
}
