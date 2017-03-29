package com.virtualminds.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jocopernicus on 3/22/2017.
 */
@Controller
public class LoginController {
/*    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
}