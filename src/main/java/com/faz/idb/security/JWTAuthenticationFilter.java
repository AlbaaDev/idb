package com.faz.idb.security;

import java.io.IOException;  
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faz.idb.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.faz.idb.security.SecurityConstants.EXPIRATION_TIME;
import static com.faz.idb.security.SecurityConstants.HEADER_STRING;
import static com.faz.idb.security.SecurityConstants.SECRET;
import static com.faz.idb.security.SecurityConstants.TOKEN_PREFIX;

/**
 * @author FAZLIU Arber
 * Class that permite the user to authenticate with JWT token
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Attempt to authenticate the user with credentials
     * @return JWT token to use inside the application
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
    	try {
    	     User creds = null;
	        if (req.getParameter("userName") != null  && req.getParameter("password") != null) {
	            creds = new User();              
	            creds.setEmail(req.getParameter("userName"));
	            creds.setPassword(req.getParameter("password"));                
	        } else {
	            creds = new ObjectMapper()
	                    .readValue(req.getInputStream(), User.class);
	        }
	        return authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        creds.getEmail(),
	                        creds.getPassword(),
	                        new ArrayList<>())
	        );
        } catch (IOException e) {
        
            throw new RuntimeException(e);
        }
    }

    /**
     * User successfully logged
     * @return JWT token to use inside the application
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((LoggedUser) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
