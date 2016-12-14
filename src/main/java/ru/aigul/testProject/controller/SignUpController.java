package ru.aigul.testProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.aigul.testProject.entity.Roles;
import ru.aigul.testProject.entity.User;
import ru.aigul.testProject.exception.DublicateException;
import ru.aigul.testProject.form.UserForm;
import ru.aigul.testProject.security.UserInfo;
import ru.aigul.testProject.services.UserService;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by Aigul on 07.12.2016.
 * Контроллер для регистрации пользователя
 */
@Controller
public class SignUpController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private UserService userService;

    /**
    * Метод обрабатывающий GET-запросы "/sign-up"
    * @return String
    */
    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String getSignUpPage() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if((principal instanceof UserInfo) && !((UserInfo)principal).getAuthorities().isEmpty()){
            logger.info("User authorities. Redirect in welcome page.");
            return "redirect:/welcome";
        }
        logger.info("Get sign-up.jsp");
        return "sign-up";
    }

    /**
     * Метод регистрации пользователя
     * @param userForm UserForm
     * @param result BindingResult
     * @return ModelAndView
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView signUpUser(@Valid @ModelAttribute("reg") UserForm userForm, BindingResult result) throws ServletException, IOException {
        if (result.hasErrors()) {
            logger.error("Registration error");
            return new ModelAndView("sign-up");
        }

        User user = new User();
        user.setName(userForm.getName().trim());
        user.setPassword(userForm.getPassword().trim());
        user.setRole(Roles.ROLE_USER);

        logger.info("New User = " + user.toString());

        try {
            userService.addUser(user);
            logger.info("User added");
        } catch (DublicateException e) {
            e.printStackTrace();
            logger.info("Dublicate User name = " + user.getName());
            return new ModelAndView("sign-up").addObject("error", "Пользователь с таким именем уже существует");
        }

        UserInfo userInfo = new UserInfo(user);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userInfo, null, userInfo.getAuthorities());
        token.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(token);

        logger.info("User authorities. Redirect in welcome page.");

        return new ModelAndView("redirect:/welcome");
    }
}
