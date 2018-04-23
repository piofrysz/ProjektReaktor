package com.pwn.projektreaktorspring.controllers;


import com.pwn.projektreaktorspring.models.User;
import com.pwn.projektreaktorspring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/")
    public String login(@Valid @ModelAttribute User user, BindingResult result){
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            return "";
        }
        else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setHaslo(passwordEncoder.encode(user.getHaslo()));
            userRepo.save(user);
            return "zalogowanyView";
        }
    }

}
