package com.forestnewark.controller;

import com.forestnewark.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for Login page
 */
@Controller
@SessionAttributes("currentUser")
public class LoginController {

    final
    CookieService cs;

    @Autowired
    public LoginController(CookieService cs) {
        this.cs = cs;
    }


    /*
    Returns Login html page from root request
     */
    @RequestMapping("/")
    public String login(ModelMap model, HttpServletRequest request) {

        //Handle login cookies
        cs.readLoginCookies(model, request);

        return "login";
    }


}
