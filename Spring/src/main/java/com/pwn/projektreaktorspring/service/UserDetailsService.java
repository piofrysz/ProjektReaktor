package com.pwn.blog.service;

import com.pwn.projektreaktorspring.models.User;
import com.pwn.projektreaktorspring.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyAppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {

        User activeUserInfo                   = userRepo.getByLogin(userLogin);

        if(activeUserInfo == null) throw new UsernameNotFoundException("Nie odnaleziono użytkownika.");
        GrantedAuthority authority            = new SimpleGrantedAuthority(activeUserInfo.getRole());

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userLoginVal                    = activeUserInfo.getLogin();
        String userPasswdVal                 = activeUserInfo.getPassword();
//        String userSurnameVal                 = passwordEncoder.encode(activeUserInfo.getPassword());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(userLoginVal, userPasswdVal, Arrays.asList(authority));
        return userDetails;
    }
}