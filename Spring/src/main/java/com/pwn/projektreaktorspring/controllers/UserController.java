package com.pwn.projektreaktorspring.controllers;

import com.pwn.projektreaktorspring.models.User;
import com.pwn.projektreaktorspring.repositories.UserRepo;
import com.pwn.projektreaktorspring.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    MyUserDetailsService muds;

    @Secured("ROLE_USER")
    @GetMapping("/zalogowany")
    public String zalogowany(Model model){
        System.out.println("Mail: " + muds.userDetails.getUsername());
        User daneUser = userRepo.getByMail(muds.userDetails.getUsername());
        model.addAttribute("user", daneUser);
        return "zalogowanyView";
    }

//    @Secured({"ROLE_ADMIN","ROLE_USER"})


//    @GetMapping("/update")
//    public String update(Model model){
//        model.addAttribute("")
//    }
}
