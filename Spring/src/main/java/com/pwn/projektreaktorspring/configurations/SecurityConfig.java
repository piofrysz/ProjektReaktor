package com.pwn.projektreaktorspring.configurations;

import com.pwn.projektreaktorspring.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/").permitAll()
//                .antMatchers("/zalogowany").hasAnyRole("ADMIN", "USER")

                .and().formLogin()  //login configuration
                .loginPage("/")
                .loginProcessingUrl("/")
                .usernameParameter("app_username")
                .passwordParameter("app_password")
                .defaultSuccessUrl("/zalogowany")

                .and().logout()    //logout configuration
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")

                .and().exceptionHandling() //exception handling configuration
                .accessDeniedPage("/error-view");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);
    }
}