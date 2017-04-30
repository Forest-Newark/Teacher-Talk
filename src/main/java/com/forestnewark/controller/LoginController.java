package com.forestnewark.controller;

import com.forestnewark.bean.Parent;
import com.forestnewark.repository.ParentRepository;
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
    ParentRepository parentRepository;

    final
    LoginService ls;

    final
    CookieService cs;

    @Autowired
    public LoginController(CookieService cs, LoginService ls, ParentRepository parentRepository) {
        this.cs = cs;
        this.ls = ls;

        this.parentRepository = parentRepository;
    }

    /*
    Returns Login html page from root request
     */
    @RequestMapping("/")
    public String loginPage(ModelMap model, HttpServletRequest request) {

        //Handle login cookies
        cs.readLoginCookies(model, request);

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(ModelMap model,@RequestParam("loginEmail") String loginEmail, @RequestParam("loginPassword") String password) {


        if (ls.validateUser(loginEmail, password)) {
            if (ls.userType(loginEmail).equals("teacher")) {

                model.put("currentUser",loginEmail);
                return new RedirectView("/teacher");

            } else if (ls.userType(loginEmail).equals("parent")) {

                model.put("currentUser",loginEmail);
                return new RedirectView("/parent");
            }

        }
            return new RedirectView("/");

    }

    @RequestMapping("/parent")
    public String parentSignUp(ModelMap model) {

        Parent parent = parentRepository.findByPrimaryEmail((String) model.get("currentUser")).get(0);

        model.addAttribute("parent",parent);

        return "parent";
    }

    @RequestMapping("/teacherSignUp")
    public String teacherSignUp(){
        return "teacherSignUp";
    }

    @RequestMapping("/teacher")
    public String teacher(){
        return "teacher";
    }

}


