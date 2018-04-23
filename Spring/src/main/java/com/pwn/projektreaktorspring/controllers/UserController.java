package com.pwn.projektreaktorspring.controllers;

import com.pwn.projektreaktorspring.models.User;
import com.pwn.projektreaktorspring.repositories.UserRepo;
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


//    @Secured({"ROLE_ADMIN","ROLE_USER"})
//    @RequestMapping("/zalogowany")
//    public String zalogowany(@RequestParam String mail, Model model){
//        User daneUser = userRepo.getByMail(mail);
//        model.addAttribute("user", daneUser);
//        return "zalogowanyView";
//    }
//    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @RequestMapping("/zalogowany")
    public String zalogowany(Model model) {
        User daneUser = userRepo.getByMail("a@a.pl");
        model.addAttribute("user", daneUser);
        return "zalogowanyView";
    }

//    @GetMapping("/update")
//    public String update(Model model){
//        model.addAttribute("")
//    }
}
