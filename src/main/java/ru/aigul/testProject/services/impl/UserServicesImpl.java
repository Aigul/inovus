package ru.aigul.testProject.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.aigul.testProject.entity.User;
import ru.aigul.testProject.exception.DublicateException;
import ru.aigul.testProject.repository.UserRepository;
import ru.aigul.testProject.services.UserService;

/**
 * Created by Aigul on 07.12.2016.
 * Реализация интерфейса UserService
 */
@Service
public class UserServicesImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Добавление нового пользователя
     * @param user User
     */
    @Override
    public void addUser(User user) throws DublicateException {
        User user1 = userRepository.findByNameNoRegistr(user.getName());
        if(user1 != null) {
            throw new DublicateException();
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * Поиск пользователя по имени
     * @param name String
     * @return User
     */
    @Override
    public User find(String name) {
        User user = userRepository.findByName(name);
        return user;
    }

}
