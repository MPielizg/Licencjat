package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.model.dto.UserDTO;
import pl.pielizg.messageExchanger.service.UserService;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */
@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "")
    ResponseEntity<?> printUsers(@PageableDefault(size = 10, sort = "surname") Pageable pageable){
        Page<UserDTO> page = service.printUsers(pageable);
        return page != null ? new ResponseEntity<Page<UserDTO>>(page, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> findUserById(@PathVariable("id") int id){
        UserDTO userDTO = service.findById(id);

        return userDTO != null ? new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "")
    ResponseEntity<?> insertUser(@RequestBody UserDTO userDTO){
        UserDTO user = service.insertUser(userDTO);

        return user != null ? new ResponseEntity<UserDTO>(user, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{phoneNumber}")
    void deleteUser(@PathVariable("phoneNumber") Long phoneNumber){
        service.deleteUser(phoneNumber);
    }
}
