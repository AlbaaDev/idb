/**
 * 
 */
package com.faz.idb.security;

/**
 * @author FAZLIU Arber
 *
 */
public final class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String REGISTER_USERS_URL = "/*/register";
    public static final String LOG_IN_URL = "/customers/authenticate";
    public static final String GET_ACCOUNTS_URL = "/*/accounts";
    public static final String HOME = "/home";
    public static final String ALL_USERS = "/users/all";
}
