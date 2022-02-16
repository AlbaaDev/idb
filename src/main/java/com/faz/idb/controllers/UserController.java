package com.faz.idb.controllers;

import java.util.List;

import com.faz.idb.jwt.JwtRequest;
import com.faz.idb.jwt.JwtResponse;
import com.faz.idb.jwt.JwtUtility;
import com.faz.idb.models.User;
import com.faz.idb.security.LoggedUser;
import com.faz.idb.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/users")
public class UserController {
	
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    private JwtUtility jwtUtility;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/all")
	public List<User> getAll() {
		return userDetailsService.getAll();
	}

	@PostMapping("/register")
	public void register(@RequestBody User userForm) {
		User userToSave = new User();
		userToSave.setFirstName(userForm.getFirstName());
		userToSave.setLastName(userForm.getLastName());
		userToSave.setGender(userForm.getGender());
		userToSave.setAdress(userForm.getAdress());
		userToSave.setCity(userForm.getCity());
		userToSave.setProvince(userForm.getProvince());
		userToSave.setPostCode(userForm.getPostCode());
		userToSave.setPhoneNumber(userForm.getPhoneNumber());
		userToSave.setEmail(userForm.getEmail());
		userToSave.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
		userDetailsService.save(userToSave);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
	     try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getEmail(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	        final LoggedUser loggedUser
	                = (LoggedUser) userDetailsService.loadUserByUsername(jwtRequest.getEmail());

	        final String jwtToken =
	                jwtUtility.generateToken(loggedUser);
	        return ResponseEntity.ok(new JwtResponse(jwtToken, loggedUser));
	}
}
