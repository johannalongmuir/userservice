package com.manchesterdigital.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
    // https://docs.spring.io/spring-security/site/docs/current/guides/html5/hellomvc-javaconfig.html

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/home").permitAll()
                    .antMatchers("/users/index").permitAll()   //TODO remove this. Just added so could look at it when practicing.
                    .antMatchers("/h2-console/**").permitAll()
                    .antMatchers("/login/added").permitAll()
                    .antMatchers("/users/create").permitAll()
                    .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

// TODO LOOK AT THIS.
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("password").roles("ROLE_USER");
//    }

}
