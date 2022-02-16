/**
 * 
 */
package com.faz.idb.security;

import java.util.Collection;

import com.faz.idb.Gender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author FAZLIU Arber
 *
 */
public class LoggedUser implements UserDetails {
	
	private final Long id;
	private final String email;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final String adress;
	private final String city;
	private final String province;
	private final String phoneNumber;
	private final long postCode;

	public LoggedUser(Long id, String email, String password, String firstName, String lastName, String adress, String city, String province, long postCode, String phoneNumber) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.city = city;
		this.province = province;
		this.postCode = postCode;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAdress() {
		return adress;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public long getPostCode() {
		return postCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
