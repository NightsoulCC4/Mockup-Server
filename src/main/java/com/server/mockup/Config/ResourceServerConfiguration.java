package com.server.mockup.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Value("${spring.security.user.authorities}")
    private String role;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // For using h2-console on your web browser. You need to disable csrf and header frameOptions.
        http.csrf().disable();
        http.headers().frameOptions().disable();

        // You can configurate which path are they need token.
        http
                .authorizeRequests()
                .antMatchers("/example/api/**").hasRole(role)
                .and().httpBasic();
    }
}
