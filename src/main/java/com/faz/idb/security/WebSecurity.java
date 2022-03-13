package com.faz.idb.security;

import com.faz.idb.jwt.JwtFilter;
import com.faz.idb.service.AbstractUserServiceImpl;
import com.faz.idb.service.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.faz.idb.security.SecurityConstants.*;


/**
 * @author FAZLIU Arber
 * Class to integrate the security filters
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtFilter jwtFitler;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AbstractUserServiceImpl userService;

	@Autowired
	private CustomAuthenticationProvider authProvider;
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
    /**
     * Method where we define which resources are public and which are secured
     * @param http
     * @throws Exception
     */
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, REGISTER_USERS_URL, LOG_IN_URL).permitAll()
				.antMatchers(HttpMethod.GET, "/", HOME, GET_ACCOUNTS_URL).permitAll()
				.antMatchers("/**.js").permitAll()
				.antMatchers("/**.css").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtFitler, UsernamePasswordAuthenticationFilter.class);
	}
    /**
     * Method where we defined a custom implementation of UserDetailsService 
     * to load user-specific data in the security framework
     * @param auth the authentication builder
     * @throws Exception A general exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Bean
	CorsConfigurationSource corsConfigurationSource() {
	   final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	   source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	   return source;
	}
}
