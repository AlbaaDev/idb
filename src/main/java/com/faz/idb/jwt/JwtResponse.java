/**
 * @author FAZLIU Arber
 */
package com.faz.idb.jwt;

import com.faz.idb.dto.AbstractUserDto;

public class JwtResponse {

    private final String jwt;
    private final AbstractUserDto userDto;

    public JwtResponse(String jwt, AbstractUserDto userDto) {
        this.jwt = jwt;
        this.userDto = userDto;
    }

    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }

    public AbstractUserDto getUser() {
        return userDto;
    }
}
