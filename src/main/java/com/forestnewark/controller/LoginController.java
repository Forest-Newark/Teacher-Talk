package com.forestnewark.controller;

import com.forestnewark.service.CookieService;
import com.forestnewark.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for Login page
 */
@Controller
@SessionAttributes("currentUser")
public class LoginController {


    final
    LoginService ls;

    final
    CookieService cs;

    @Autowired
    public LoginController(CookieService cs, LoginService ls) {
        this.cs = cs;
        this.ls = ls;

    }

    /*
    Returns Login html page from root request
     */
    @RequestMapping("/")
    public String landingPage(ModelMap model, HttpServletRequest request) {

        //Handle login cookies
        cs.readLoginCookies(model, request);

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(@RequestParam("loginEmail") String loginEmail, @RequestParam("loginPassword") String password) {


        if (ls.validateUser(loginEmail, password)) {
            if (ls.userType(loginEmail).equals("teacher")) {

                return new RedirectView("/teacher");

            } else if (ls.userType(loginEmail).equals("parent")) {

                return new RedirectView("/parentSignUp");
            }

        }
            return new RedirectView("/");

    }

}
