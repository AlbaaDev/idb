/**
 * 
 */
package com.faz.idb.service;

import java.util.List;

import com.faz.idb.models.User;
import com.faz.idb.repositories.UserRepository;
import com.faz.idb.security.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, IUserService {
	
    @Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User userFromDB = userRepository.findByEmail(email);

		if(userFromDB == null) {
			throw new UsernameNotFoundException(email);
		}
		return new LoggedUser(userFromDB.getId(), userFromDB.getEmail(), userFromDB.getPassword());
	}
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
