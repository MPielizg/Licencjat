package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.model.dto.Container;
import pl.pielizg.messageExchanger.service.ExchangeService;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-21.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/getmessage")
public class ExchangeController {

    @Autowired
    private ExchangeService service;

    @PostMapping(value = "/text")
    ResponseEntity<Container> getText(@RequestBody String text){
        Container container = service.setMessage(text);

        return container.getPhoneNumbers()!=null ? new ResponseEntity<Container>(HttpStatus.OK) : new ResponseEntity<Container>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "")
    ResponseEntity<?> getUnsendMessages(){
        Container container = service.getUnsend();

        return container != null ? new ResponseEntity<Container>(container, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
    }
}
