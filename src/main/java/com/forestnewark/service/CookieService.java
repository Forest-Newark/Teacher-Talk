package com.forestnewark.service;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class CookieService {



    public void saveUserEmail(HttpServletResponse response,String loginEmail) {

        Cookie cookieLoginEmail = new Cookie("loginEmail", loginEmail);
        cookieLoginEmail.setMaxAge(60*60);
        response.addCookie(cookieLoginEmail);
    }



    public String readEmailCookie(HttpServletRequest request) {



        //Check for and read cookie values for saved user login credentials
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            if (cookies.length > 0) {
                //Loop Through All Cookies
                for (int i = 0; i < cookies.length; i++) {

<<<<<<< HEAD
                    //Check for UserName Cookie
                    if (cookies[i].getName().equals("loginEmail")) {
                        //Set UserName to Model Attribute
                        return cookies[i].getValue();
                    }
                }
            }
        }


=======
                //Check for UserName Cookie
                if (cookies[i].getName().equals("loginEmail")) {
                    //Returns loginEmail Value
                   return cookies[i].getValue();
                }
            }
        }//Otherwise return null
>>>>>>> 880b92216a8d0abc0ac451b71772543b6edf304f
        return null;

    }
}
