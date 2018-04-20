package com.intech.configurations;

<<<<<<< HEAD

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
=======
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

>>>>>>> formation-2018-angular
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
<<<<<<< HEAD
    @Autowired
    private ObjectMapper jsObjectMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                // Permit Options to Avoid CORS problems during development
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/webjars/springfox-swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
                .antMatchers(HttpMethod.GET, "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JwtAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);

        jsObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        jsObjectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
}
=======

    @Autowired
    private ObjectMapper jsObjectMapper;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        // Permit Options to Avoid CORS problems during development
		.antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/webjars/springfox-swagger-ui/**").permitAll()
        .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
        .antMatchers(HttpMethod.GET, "/images/**").permitAll()
        .anyRequest().authenticated()
        .and()
        // And filter other requests to check the presence of JWT in header
        .addFilterBefore(new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);

        jsObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        jsObjectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
  }
}
>>>>>>> formation-2018-angular
