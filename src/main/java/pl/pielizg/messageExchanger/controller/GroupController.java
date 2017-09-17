package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.model.dto.GroupDTO;
import pl.pielizg.messageExchanger.service.GroupService;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-28.
 */
@RestController
@RequestMapping(value = "/group")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    @Autowired
    GroupService service;

    @GetMapping(value = "/{name}")
    ResponseEntity<?> getGroupsBySubjectName(@PathVariable("name") String name){
        List<GroupDTO> groupDTOs = service.findGroupsBySubjectName(name);

        return groupDTOs.size() != 0 ? new ResponseEntity<List<GroupDTO>>(groupDTOs, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }
}
