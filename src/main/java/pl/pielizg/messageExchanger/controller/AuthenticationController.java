package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.service.UserService;

/**
 * Created by Pielizg on 2017-09-10.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/usersAuth")
public class AuthenticationController {

    @Autowired
    private UserService service;

    @PostMapping(value = "")
    ResponseEntity<String> getPassword(@RequestBody String login){
        String password = service.getPassword(login);

        return password!="###" ? new ResponseEntity<String>(password, HttpStatus.OK) : new ResponseEntity<String>(password, HttpStatus.BAD_REQUEST);
    }
}
