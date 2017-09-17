package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.model.dto.SubjectDTO;
import pl.pielizg.messageExchanger.service.SubjectService;

/**
 * Created by Pielizg on 2017-08-21.
 */
@RestController
@RequestMapping(value = "/subject")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping(value = "")
    ResponseEntity<?> printSubjects(@PageableDefault(size = 10, sort = "name")Pageable pageable){

        Page<SubjectDTO> page = service.printSubjects(pageable);

        return page.getSize() != 0 ? new ResponseEntity<Page<SubjectDTO>>(page, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> findSubjectById(@PathVariable("id") int id){
        SubjectDTO subjectDTO = service.findSubjectById(id);

        return subjectDTO != null ? new ResponseEntity<SubjectDTO>(subjectDTO, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "")
    ResponseEntity<?> insertSubject(@RequestBody SubjectDTO subjectDTO){
        SubjectDTO subject = service.insertSubject(subjectDTO);

        return subject != null ? new ResponseEntity<SubjectDTO>(subject, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }
}
