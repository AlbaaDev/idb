/**
 * @author FAZLIU Arber
 * @date 04.03.22
 **/

package com.faz.idb.controllers;

import com.faz.idb.models.Adviser;
import com.faz.idb.service.IAbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adviser")
public class AdviserController extends AbstractUserController<Adviser> {

    @Autowired
    public AdviserController(IAbstractUserService<Adviser> userService) {
        super(userService);
    }
}
