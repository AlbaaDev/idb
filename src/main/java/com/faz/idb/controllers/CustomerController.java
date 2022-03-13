/**
 * @author FAZLIU Arber
 * @date 04.03.22
 **/

package com.faz.idb.controllers;

import com.faz.idb.models.Customer;
import com.faz.idb.service.IAbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractUserController<Customer> {

    @Autowired
    public CustomerController(IAbstractUserService<Customer> userService) {
        super(userService);
    }
}
