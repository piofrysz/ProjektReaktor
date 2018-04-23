package com.pwn.projektreaktorspring.controllers;


import com.pwn.projektreaktorspring.models.User;
import com.pwn.projektreaktorspring.repositories.UserRepo;
import com.pwn.projektreaktorspring.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepo userRepo;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/")
    public String home(@Valid @ModelAttribute User user, BindingResult result){
        if(result.hasErrors()){

        }
        return "index";
    }

    @GetMapping("/error-view")
    public String errorViewHandler(){
        return "error";
    }

}
