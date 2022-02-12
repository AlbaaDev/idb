/**
 * 
 */
package com.faz.idb.jwt;

/**
 * @author abi
 *
 */
public class JwtResponse {
	
	private final String jwt;

	/**
	 * @param jwt
	 */
	public JwtResponse(String jwt) {
		this.jwt = jwt;
	}
	
	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}
}
