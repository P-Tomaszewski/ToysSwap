package com.tomaszewski.ToysSwap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@SpringBootApplication
public class ToysSwapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToysSwapApplication.class, args);
	}

//	@GetMapping("/user")
//	@ResponseBody
//	public Principal user(Principal user) {
//		return user;
//	}
//
//	@Configuration
//	@Order(SecurityProperties.BASIC_AUTH_ORDER) //?
//	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//					.httpBasic()
//					.and()
//					.authorizeRequests()
//					.antMatchers("/index.html", "/announcements", "/home", "/login").permitAll()
//					.anyRequest().authenticated()
//					.and()
//					.csrf()
//					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		}
//	}

}
