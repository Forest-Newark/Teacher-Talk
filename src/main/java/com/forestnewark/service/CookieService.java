package com.forestnewark.service;

import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by forestnewark on 4/28/17.
 */
public class CookieService {


    public void readLoginCookies(ModelMap model,HttpServletRequest request){

        //Check for and read cookie values for saved user login credentials
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0) {
            //Loop Through All Cookies
            for (int i = 0; i < cookies.length; i++) {
                //Check for UserName Cookie
                if (cookies[i].getName().equals("username")) {
                    //Set UserName to Model Attribute
                    model.put("currentUser", cookies[i].getValue());
                }
                //Check for rememberMe Cookie
                if (cookies[i].getName().equals("rememberMe")) {
                    //Check for Value of Remember Me
                    if (cookies[i].getValue().equals("true")) {
                        //If rememberMe - Turn rememberMe Value On
                        model.addAttribute("rememberMe", "on");
                    } else {

                        //If not rememeberMe - Turn rememberMe Value Off
                        model.addAttribute("rememberMe", "off");
                    }
                }

            }
        }




    }





}
