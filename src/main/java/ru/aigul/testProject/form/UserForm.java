package ru.aigul.testProject.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Aigul on 09.12.2016.
 * Форма для проверки валидности введенных данных
 */
public class UserForm {

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{4,}$",
            message = "Имя пользователя должно быть длиннее 4 символов и состоять из цифр и букв английского алфавита")
    private String name;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$",
            message = "Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длина минимум 8 символов")
    private String password;

    @NotNull
    private String repassword;

    /**
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Метод получения name пользователя
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод получения repassword пользователя
     * @return String
     */
    public String getRepassword() {
        return repassword;
    }

    /**
     *
     * @param repassword String
     */
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    /**
     * Проверка пароля и повтора пароля
     * @return boolean
     */
    @AssertTrue(message = "Пароль и повтор пароля не совпадают")
    public boolean isPasswordValid() {
        return this.password == null || this.password.equals(this.repassword);
    }
}