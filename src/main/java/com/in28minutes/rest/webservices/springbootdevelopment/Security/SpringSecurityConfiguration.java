package com.in28minutes.rest.webservices.springbootdevelopment.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        // 1-> all request needs to be authenticated

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // 2 -> Login pop-ups for request

        http.httpBasic(Customizer.withDefaults());

        // 3-> csrf to be disabled for PUT &  POST type HTTP Request

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
