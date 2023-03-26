package com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
	auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
	}
<<<<<<< HEAD
<<<<<<< HEAD
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .requestMatchers("/tasks")
            .permitAll()
            .anyRequest()
            .authenticated();
        return http.build();
        
    }
=======
=======
>>>>>>> parent of 9446e79 (Update SecurityConfig.java)
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.csrf().disable();
		http.authorizeRequests().requestMatchers("/login/**","register/**");
		http.authorizeRequests().requestMatchers(HttpMethod.POST,"/tasks/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		}
>>>>>>> parent of 9446e79 (Update SecurityConfig.java)
}
