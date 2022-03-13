/**
 * @author FAZLIU Arber
 * @date 09.03.22
 **/
package com.faz.idb.service;


import com.faz.idb.models.AbstractUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Resource
    AbstractUserServiceImpl<?> userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String identifier = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        if (identifier == null) {
            throw new BadCredentialsException("Invalid login details");
        }
        AbstractUser user;
        if(userService.getUserByEmail(identifier) == null) {
            throw new BadCredentialsException("Invalid login details");
        }
        user = userService.getUserByEmail(identifier);
        return createSuccessfulAuthentication(authentication, user);
    }
    //TODO
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private Authentication createSuccessfulAuthentication(final Authentication authentication, final AbstractUser user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), authentication.getCredentials(), user.getAuthorities());
        token.setDetails(authentication.getDetails());
        return token;
    }
}
