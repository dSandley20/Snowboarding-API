package com.dsandley.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dsandley.filters.JwtRequestFilter;
import com.dsandley.services.authentication.AuthUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    /**
     * allows us to instantiate the AutehnticationManager bean.
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * allows us to use our custom JWT filter.
     */
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /**
     * Connects the AuthUserDetailsService to the configurer.
     */
    @Autowired
    private AuthUserDetailsService authUserDetailsService;



    /**
     * Points to the new userDetailsService that our application is going to
     * use.
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(authUserDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * tells our application what endpoints that don't need to be logged in for.
     * @param httpParam
     *            - dont't worry about this since it's getting passed in for us.
     */
    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        //TODO add createUser endpoint here for new users!
        httpParam.csrf().disable().authorizeRequests()
                .antMatchers("/authenticate", "/user", "/locations"). permitAll().anyRequest()
                .authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpParam.addFilterBefore(jwtRequestFilter,
                UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * encodes the password to not store passwords in plain text.
     * @return password
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
