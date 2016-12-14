package ru.aigul.testProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Aigul on 07.12.2016.
 * Базовый контроллер
 */
@Controller
public class BaseController {

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;
}
