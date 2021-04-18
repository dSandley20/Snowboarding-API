package com.dsandley.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


import com.dsandley.services.AuthUserDetailsService;

@SuppressWarnings({"deprecation", "unused"})
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    /**
     * encodes the password to not store passwords in plain text.
     * @return password
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    /**
     * Connects the AuthUserDetailsService to the configurer.
     */
    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    /**
     * Not sure what this does yet.
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(authUserDetailsService);
    }

}
