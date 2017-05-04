package com.forestnewark.controller;

import com.forestnewark.bean.Parent;
import com.forestnewark.bean.Teacher;
import com.forestnewark.service.CookieService;
import com.forestnewark.service.DatabaseService;

import com.forestnewark.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

/**
 * Controller for Teacher Talk
 */
@Controller
@SessionAttributes("currentUser")
public class TeacherTalkController {

    final
    MessageService ms;

    private final
    DatabaseService ds;

    private final
    CookieService cs;

    @Autowired
    public TeacherTalkController(CookieService cs, DatabaseService ds, MessageService ms) {
        this.cs = cs;
        this.ds = ds;
        this.ms = ms;
    }


    /**
     * Request for site root
     *
     * @param model   to set model attributes
     * @param request to read user cookies
     * @return login page
     */
    @RequestMapping("/")
    public String loginPage(ModelMap model, HttpServletRequest request) {


        if (cs.readEmailCookie(request) != null) {
            model.addAttribute("userEmail", cs.readEmailCookie(request));
            model.addAttribute("userPassword", ds.getUserPassword(cs.readEmailCookie(request)));
            model.addAttribute("rememberMe", true);
        }
        return "login";
    }


    /**
     * Request for site login
     *
     * @param model      to set model attributes
     * @param response   to save userEmail cookie if rememeber me box is seleted
     * @param loginEmail of the current user
     * @param password   of the current user
     * @param rememberMe option to create cookies for site
     * @return RedirectView to correct page based on user login credentials
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(ModelMap model, HttpServletResponse response, @RequestParam("loginEmail") String loginEmail, @RequestParam("loginPassword") String password, @RequestParam(value = "rememberMe", required = false, defaultValue = "dontRememberMe") String rememberMe) {
        if (ds.validateUser(loginEmail, password)) {
            if (ds.userType(loginEmail).equals("teacher")) {

                model.put("currentUser", loginEmail);
                if (rememberMe.equals("rememberMe")) {
                    cs.saveUserEmail(response, loginEmail);
                }
                return new RedirectView("/teacher");

            } else if (ds.userType(loginEmail).equals("parent")) {

                model.put("currentUser", loginEmail);
                if (rememberMe.equals("rememberMe")) {
                    cs.saveUserEmail(response, loginEmail);
                }
                return new RedirectView("/parentLogin");
            }

        }
        return new RedirectView("/");

    }

    /**
     * Request for parent sign up page
     *
     * @param model to set model attributes
     * @return parent page
     */
    @RequestMapping("/parentSignUp")
    public String parentSignUp(ModelMap model) {

        Parent parent = new Parent();
        model.addAttribute("parent", parent);

        return "parent";
    }

    /**
     * Request for parent page after logging in
     *
     * @param model      to set model attributes
     * @param rememberMe
     * @return
     */
    @RequestMapping("/parentLogin")
    public String parentLogin(ModelMap model, String rememberMe) {

        Parent parent = ds.parentByPrimaryEmail(model.get("currentUser").toString());
        model.addAttribute("parent", parent);
        model.addAttribute("rememberMe", rememberMe);

        return "parent";
    }

    @RequestMapping("/teacherSignUp")
    public String teacherSignUp(ModelMap model) {

        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "teacherSignUp";
    }

    @RequestMapping("/teacher")
    public String teacher(ModelMap model) {


        model.addAttribute("students", ds.getAllStudents());
        model.addAttribute("messages", ds.getAllMessages());

        return "teacher";
    }

    @RequestMapping("/sendMessage")
    public RedirectView sendMessage(@RequestParam Map<String, String> params) {

        ArrayList<String> studentIdList = new ArrayList<>();
        String messageName = null;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().contains("studentddl")) {
                studentIdList.add(entry.getValue());
            }
            if (entry.getKey().contains("message")) {
                messageName = entry.getValue();
            }

        }

        for (String studentId : studentIdList) {

            ms.sendMessage(studentId, messageName);

        }

        return new RedirectView("/teacher");
    }

    @RequestMapping("/messageLog")
    public String messageLog(ModelMap model, String value) {

            System.out.println(value);

            if(value == null){
                model.addAttribute("messages",ds.getAllLog());
            }


//            model.addAttribute("messages", ds.getAllMessagesOrderById());



//        if (value = "student name") {
//            model.addAttribute("message", ds.getAllMessagesOrderByStudentName());
//        }
//        if (value = "parent name") {
//            model.addAttribute("message", ds.getAllMessagesOrderByParentName());
//        }
//        if (value = "local date") {
//            model.addAttribute("message", ds.getAllMessagesOrderByLocalDate());
//        }
//        if (value = "template sent") {
//            model.addAttribute("message", ds.getAllMessagesOrderByTemplateSent());
//        }
//        if (value = "notes") {
//            model.addAttribute("message", ds.getAllMessagesOrderByNotes());
//        }


        return "messageLog";
    }

//    /mesageLog?value=name

}


