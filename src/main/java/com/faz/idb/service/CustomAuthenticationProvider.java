/**
 * @author FAZLIU Arber
 * @date 09.03.22
 **/
package com.faz.idb.service;


import com.faz.idb.models.AbstractUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AbstractUserServiceImpl<? extends AbstractUser> userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String identifier = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        AbstractUser user = userService.getUserByEmail(identifier);
        if (identifier == null || user == null) {
            throw new BadCredentialsException("Invalid login details");
        }

        return createSuccessfulAuthentication(authentication, user.getPassword());
    }

    //TODO
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private Authentication createSuccessfulAuthentication(final Authentication authentication, final String password) {
        UsernamePasswordAuthenticationToken authenticationToken = null;
        if (passwordEncoder.matches((CharSequence) authentication.getCredentials(), password)) {
            //TODO return UsernamePasswordAuthenticationToken with autorities
            authenticationToken =
                    new UsernamePasswordAuthenticationToken(authentication.getCredentials(),
                            password, null);
        }
        return authenticationToken;
    }
}
