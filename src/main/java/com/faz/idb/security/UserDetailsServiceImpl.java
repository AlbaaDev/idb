package com.faz.idb.security;

import com.faz.idb.models.User;
import com.faz.idb.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User userFromDB = userRepository.findByEmail(email);
		
		if(userFromDB == null) {
			throw new UsernameNotFoundException(email);
		}
		return new LoggedUser(userFromDB.getId(), userFromDB.getEmail(), userFromDB.getPassword());
	}
}
