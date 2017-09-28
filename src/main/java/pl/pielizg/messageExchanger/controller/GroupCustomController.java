package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.model.dto.GroupCustomDTO;
import pl.pielizg.messageExchanger.service.GroupCustomService;

import java.util.List;

/**
 * Created by Pielizg on 2017-09-14.
 */
@RestController
@RequestMapping(value = "/customgroup")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupCustomController {

    @Autowired
    private GroupCustomService service;
    
    @PostMapping(value = "")
    void insertGroupCustom(@RequestBody GroupCustomDTO groupCustomDTO){
        service.insertGroupCustom(groupCustomDTO);
    }

    @GetMapping(value = "")
    ResponseEntity<?> getCustomGroups(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "name") String name){
        List<GroupCustomDTO> groupCustomDTOs = service.findCustomGroups(login, name);

        return groupCustomDTOs.size() != 0 ? new ResponseEntity<List<GroupCustomDTO>>(groupCustomDTOs, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }
}
