package ru.aigul.testProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.aigul.testProject.entity.User;
import ru.aigul.testProject.security.UserInfo;
import ru.aigul.testProject.services.UserService;

/**
 * Created by Aigul on 07.12.2016.
 * Контроллер приветсвия
 */
@Controller
public class WelcomeController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private UserService userService;

    /**
     * Метод обрабатывающий GET-запросы "/welcome"
     * @return ModelAndView
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView getWelcomePage() {
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        logger.debug("Get User = " +  userInfo.getUsername());
        request.setAttribute("name", userInfo.getUsername());

        logger.debug("Get welcome.jsp");

        return new ModelAndView("welcome");
    }
}
