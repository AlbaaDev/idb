/**
 * @author FAZLIU Arber
 * @date 03.03.22
 **/
package com.faz.idb.controllers;

import com.faz.idb.dto.AbstractUserDto;
import com.faz.idb.dto.UserLoginDto;
import com.faz.idb.exceptions.UserAlreadyExistsException;
import com.faz.idb.jwt.JwtResponse;
import com.faz.idb.jwt.JwtUtility;
import com.faz.idb.mapper.AbstractUserMapper;
import com.faz.idb.models.AbstractUser;
import com.faz.idb.models.Customer;
import com.faz.idb.service.IAbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractUserController<T extends AbstractUser> {
    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IAbstractUserService<T> userService;

    protected AbstractUserController(IAbstractUserService<T> userService) {
        this.userService = userService;
    }

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return The user found in the database
     */
    @GetMapping("/account/{id}")
    public ResponseEntity<AbstractUserDto> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(toDto(userService.getUserById(id)), HttpStatus.OK);
    }

    /**
     * Gets all AbstractUsers.
     *
     * @return the all fileNameToPlural
     */
    @GetMapping("/accounts")
    public ResponseEntity<List<AbstractUserDto>> getAll() {
        return new ResponseEntity<>(usersToDto(userService.getAllUsers()), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody UserLoginDto userDto) throws BadCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(),
                    userDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found", e);
        }
        T user = userService.getUserByEmail(userDto.getEmail());
        final String jwtToken = jwtUtility.generateToken(user.getEmail());
        return ResponseEntity.ok(new JwtResponse(jwtToken, toDto(user)));
    }

    /**
     * Add an account.
     *
     * @param userForm to be added.
     * @return The added account
     */
    @PostMapping("/register")
    public ResponseEntity<AbstractUserDto> register(@RequestBody AbstractUserDto userForm)
            throws UserAlreadyExistsException {
        return new ResponseEntity<>(toDto(userService.saveUser(toEntity(userForm))), HttpStatus.CREATED);
    }

    /**
     * Update the given user.
     *
     * @param userDto to be updated.
     */
    @PutMapping("/update")
    public void update(@RequestBody AbstractUserDto userDto) {
        userService.updateUser(toEntity(userDto));
    }

    /**
     * Delete user by id response entity.
     *
     * @param id the id
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }

    private AbstractUserDto toDto(AbstractUser user) {
        return AbstractUserMapper.INSTANCE.toDto(user);
    }

    private T toEntity(AbstractUserDto userDto) {
        @SuppressWarnings("unchecked") final T user = (T) AbstractUserMapper.INSTANCE.toEntity(userDto);
        return user;
    }

    private List<AbstractUserDto> usersToDto(List<T> abstractUserList) {
        return abstractUserList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
