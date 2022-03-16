/**
 *
 */
package com.faz.idb.jwt;

import com.faz.idb.jwt.JwtUtility;
import com.faz.idb.models.AbstractUser;
import com.faz.idb.service.IAbstractUserService;
import com.faz.idb.service.ICustomerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author FAZLIU Arber
 * Class to filter the Jwt
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private ICustomerService customerService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    @NotNull HttpServletResponse httpServletResponse,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");
        String jwtToken = null;
        String userName = null;

        if (authorization != null && authorization.startsWith("Bearer ")) {
            jwtToken = authorization.substring(7);
            userName = jwtUtility.getUsernameFromToken(jwtToken);
        }
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = (UserDetails) customerService.getUserByEmail(userName);

            if (Boolean.TRUE.equals(jwtUtility.validateToken(jwtToken, userDetails))) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,
                                                        null,
                                                                   userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
