package com.faz.idb.security;

import com.faz.idb.models.User;
import com.faz.idb.repositories.UserRepository;
import com.faz.idb.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, IUserService {
	
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
		return new LoggedUser(userFromDB.getId(), userFromDB.getEmail(), userFromDB.getPassword(),
				userFromDB.getFirstName(), userFromDB.getLastName(),
				userFromDB.getAdress(), userFromDB.getCity(), userFromDB.getProvince(),
				userFromDB.getPostCode(), userFromDB.getPhoneNumber());
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
