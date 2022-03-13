/**
 * @author FAZLIU Arber
 * @date 22.02.22
 **/
package com.faz.idb.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

