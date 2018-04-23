package com.pwn.projektreaktorspring.service;

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
public class MyUserDetailsService implements UserDetailsService {
    public UserDetails userDetails;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {

        User activeUserInfo                   = userRepo.getByMail(userLogin);

        if(activeUserInfo == null) throw new UsernameNotFoundException("Nie odnaleziono użytkownika.");
        GrantedAuthority authority            = new SimpleGrantedAuthority(activeUserInfo.getUprawnienia());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userLoginVal                    = activeUserInfo.getMail();
//        String userPasswdVal                 = activeUserInfo.getHaslo();
        String userPasswdVal                 = passwordEncoder.encode(activeUserInfo.getHaslo());

        userDetails = new org.springframework.security.core.userdetails.User(userLoginVal, userPasswdVal, Arrays.asList(authority));

        return userDetails;
    }
}
