package com.manchesterdigital.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //TODO be careful of this with production. Can use h2 console as approved for now with this.
    // https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .authorizeRequests()
//                  .antMatchers("/", "/home").permitAll()
//                  .anyRequest().authenticated()
//                  .and()
//                .formLogin()
//                  .loginPage("/login")
//                  .permitAll()
//                  .and()
//                .logout()
//                .permitAll();

        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/console/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}