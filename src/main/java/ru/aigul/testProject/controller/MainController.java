package ru.aigul.testProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Aigul on 07.12.2016.
 * Главный контроллер
 */
@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     * Метод обрабатывающий GET-запросы "/"
     * @return ModelAndView
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        logger.debug("Get welcome.jsp");
        return new ModelAndView("redirect:/welcome");
    }
}
