/**
 * @author FAZLIU Arber
 *
 */
package com.faz.idb.jwt;

import com.faz.idb.security.LoggedUser;

public class JwtResponse {
	
	private final String jwt;
	private final LoggedUser loggedUser;

	/**
	 * @param jwt
	 */
	public JwtResponse(String jwt, LoggedUser loggedUser) {
		this.jwt = jwt;
		this.loggedUser = loggedUser;
	}
	
	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	public LoggedUser getLoggedUser() {
		return loggedUser;
	}
}
