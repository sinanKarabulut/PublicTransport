package com.simsoft.transport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
// tüm methodların  araya girip ilk çalışacak anlamındadır.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
       /* http.authorizeRequests().anyRequest().permitAll();
        *//*http.authorizeRequests().antMatchers("/api/vehicle/*","/swagger-ui/**","/h2-console/**").permitAll()
                //.antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();*//*
        http.headers().frameOptions().sameOrigin();*/
    }
}
