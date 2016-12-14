package ru.aigul.testProject.exception;

/**
 * Created by Aigul on 12.12.2016.
 * Ошибка выбрасывается когда пытаются добавить пользователя с таким же именем
 */
public class DublicateException extends Exception {

    public DublicateException() {
        super();
    }
}
