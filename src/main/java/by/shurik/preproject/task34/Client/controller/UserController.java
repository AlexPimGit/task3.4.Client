package by.shurik.preproject.task34.Client.controller;


import by.shurik.preproject.task34.Client.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage() {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ModelAndView("user", "user", authUser);
    }
}
