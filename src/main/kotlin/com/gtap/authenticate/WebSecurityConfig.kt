package com.gtap.authenticate

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class WebSecurityConfig {


    @Bean
    fun SecurityFilterChain (http: HttpSecurity) : SecurityFilterChain{
        http
            .authorizeHttpRequests()
            .anyRequest()
            .fullyAuthenticated()
            .and()
            .formLogin();
        return http.build()
    }

    @Autowired
    fun configure(auth : AuthenticationManagerBuilder) {
        auth
            .ldapAuthentication()
            .userDnPatterns("uid={0},ou=people")
            .groupSearchBase("ou=groups")
            .contextSource()
            .url("ldap://localhost:8389/dc=springframework,dc=org")
            .and()
            .passwordCompare()
            .passwordEncoder(BCryptPasswordEncoder())
            .passwordAttribute("userPassword");
    }


}
