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
     * @param response   to save userEmail cookie if remember me box is selected
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

    //    Redirecting to teacher
    @RequestMapping("/sendMessage")
    public RedirectView sendMessage(ModelMap model,@RequestParam Map<String, String> params) {

        ArrayList<String> studentIdList = new ArrayList<>();
        String messageName = null;
        String messageText = null;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().contains("studentId")) {
                studentIdList.add(entry.getValue());
            }
            if (entry.getKey().contains("message")) {
                messageName = entry.getValue();
            }
           if (entry.getKey().contains("messageText")){
                messageText = entry.getValue();
           }

        }

        Long start = System.currentTimeMillis();


        for (String studentId : studentIdList) {

            ms.sendMessage(studentId, messageName,model.get("currentUser").toString(),messageText);

        }

        System.out.println("Run Time:");
        System.out.println(System.currentTimeMillis() - start);

        return new RedirectView("/teacher");
    }




//    Routes to forgotPasswordForm.html when user clicks "Forgot Password"
    @RequestMapping("/forgotPassword")
    public String forgotPassword(){
        return "forgotPasswordForm";
    }



//    Sends a password reset link in an email and then redirects to homepage
    @RequestMapping("/passwordResetEmail")
    public RedirectView passwordResetEmail(@RequestParam ("email") String email){

//        Gets user ID from database based on email entered
        Integer userId = ds.getUserIdByEmail(email);

        //Failure -> forgotPasswordForm
        if (userId == null){
            return new RedirectView("/forgotPasswordForm");
        }


        //Success -> Send message and go to Root


//        Message Service sends the email with the password reset link
        ms.sendPasswordResetEmail(userId, email);

        return new RedirectView("/");
    }


    @RequestMapping("/resetPassword")
    public String resetPassword(ModelMap model, Integer userId, String email){

        model.addAttribute("userId",userId);
        model.addAttribute("email", email);
        return "changePasswordForm";
    }


    @RequestMapping("/passwordResetSubmit")
    public RedirectView passwordResetSubmit(@RequestParam("password")String password,@RequestParam("userId")Integer userId, @RequestParam("email")String email) {
        System.out.println(password);
        System.out.println(userId);
        System.out.println("Made it to password reset submit");

        ds.updateUserPasswordById(userId, password, email);

        return new RedirectView ("/");
    }



    @RequestMapping("/messageLog")
    public String messageLog(ModelMap model, @RequestParam(value = "value", defaultValue = "duck") String value,String search) {

        System.out.println(value);
        System.out.println(search);
        if(search == null){
            search = "";
        }


        //if value is duck i dont care about the order

        if (value.equals("duck")) {
            model.addAttribute("messages", ds.messageLogSearch(search));
        }

        //if value is id I wanted it ordered by ID from 1 -> up
        if (value.equals("id")) {
            System.out.println("you want it ordered by id");
            model.addAttribute("messages", ds.getAllLogOrderById());
        }


        if (value.equals("studentName")) {
            System.out.println("You want it ordered by student name");
            model.addAttribute("messages", ds.getAllLogOrderByStudentName());
        }
        //if value is ParentName i want it ordered alphabetically by parent name
        if (value.equals("parentName")) {
            System.out.println("You want it ordered by parent name");
            model.addAttribute("messages", ds.getAllLogOrderByParentName());

            //ordered by parent name
        }

        //if value is TemplateSent --- order alphabetically by template sent
        if (value.equals("templateSent")) {
            System.out.println("order by template sent");
            model.addAttribute("messages", ds.getAllLogOrderByTemplateSent());
        }

        //if value is Notes then we want to order Alphabetically by notes
        if (value.equals("notes")) {
            System.out.println("order by notes");
            model.addAttribute("messages", ds.getAllLogOrderByNotes());
        }

        // if value is date then order alphabetically by date
        if (value.equals("date")) {
            System.out.println("order by date");
            model.addAttribute("messages", ds.getAllLogOrderByCreated());

        }


        return "messageLog";
    }
}








