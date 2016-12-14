package ru.aigul.testProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.aigul.testProject.security.UserInfo;

/**
 * Created by Aigul on 07.12.2016.
 * Контроллер для авторизации пользователя
 */
@Controller
public class SignInController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(SignInController.class);

    /**
     * Метод обрабатывающий GET-запросы "/sign-in"
     * @return String
     */
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String getSignInPage() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if((principal instanceof UserInfo) && !((UserInfo)principal).getAuthorities().isEmpty()){
            logger.info("User authorities. Redirect in welcome page.");
            return "redirect:/welcome";
        }
        logger.info("Get sign-in.jsp");
        return "sign-in";
    }
}
