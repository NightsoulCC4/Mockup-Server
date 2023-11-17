package com.server.mockup.Config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value("${security.oauth2.client.client-id}")
    private String client_id;

    @Value("${security.oauth2.client.client-secret}")
    private String client_secret;

    @Value("${security.oauth2.client.authorized-grant-types}")
    private String password;

    @Value("${security.oauth2.client.scope.read}")
    private String read;

    @Value("${security.oauth2.client.scope.write}")
    private String write;

    @Value("${security.oauth2.client.access-token-validity-seconds}")
    private int accessTokenValiditySeconds;

    @Value("${spring.security.user.name}")
    private String user;

    @Value("${spring.security.user.password}")
    private String user_password;

    @Value("${spring.security.user.authorities}")
    private String role;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationServerConfiguration(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser(user).password(passwordEncoder().encode(user_password)).roles(role);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // If you want to encode the client_secret, you can use passwordEncoder() function nor insert "{noop}" at the front.
        clients.inMemory()
                .withClient(client_id)
                .secret(passwordEncoder().encode(client_secret))
                .authorizedGrantTypes(password)
                .scopes(read, write)
                .accessTokenValiditySeconds(accessTokenValiditySeconds);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
