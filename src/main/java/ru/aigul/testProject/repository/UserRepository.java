package ru.aigul.testProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.aigul.testProject.entity.User;

/**
 * Created by Aigul on 07.12.2016.
 * Репозиторий для работы с таблицей users
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Поиск пользователя по имени
     * @param name String
     * @return User
     */
    User findByName(String name);

    @Query("select u from User u where  upper(u.name) like upper(:name)")
    User findByNameNoRegistr(@Param("name") String name);
}
