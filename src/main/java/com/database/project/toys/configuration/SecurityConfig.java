package com.database.project.toys.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.database.project.toys.domain.Role;
import com.database.project.toys.domain.User;
import com.database.project.toys.service.UserService;
import com.database.project.toys.serviceImplementation.CurrentUserServiceImp;

/**
 * @author nahime.torres
 * @author pia.farinella Reference link:
 *         http://kielczewski.eu/2014/12/spring-boot-security-application/
 * 
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CurrentUserServiceImp userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		userService.persist(new User(1L, "regularuser", "regularuser", Role.USER, true));
		userService.persist(new User(2L, "admin", "admin", Role.ADMIN, true));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/toys/**").hasAuthority("ADMIN").antMatchers("/toy").hasAuthority("ADMIN")
				.antMatchers("/users/**").hasAuthority("ADMIN").antMatchers("/user").hasAuthority("ADMIN")
				.antMatchers("/transactionHistory").hasAuthority("ADMIN").antMatchers("/buy/**").authenticated().and()
				.formLogin().loginPage("/login").permitAll().and().logout()
				// .logoutSuccessUrl("/")
				.permitAll().and().exceptionHandling().accessDeniedPage("/403");

	}

}