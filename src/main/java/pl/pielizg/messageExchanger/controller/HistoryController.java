package pl.pielizg.messageExchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pielizg.messageExchanger.model.dto.HistoryItemDTO;
import pl.pielizg.messageExchanger.service.HistoryService;
import org.springframework.data.domain.Pageable;


/**
 * Created by Pielizg on 2017-09-19.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    private HistoryService service;

    @GetMapping(value = "/{login}")
    ResponseEntity<?> getHistory(@PathVariable("login") String login,
                                 @PageableDefault(size = 10, sort = "date") Pageable pageable) {
        Page<HistoryItemDTO> historyItemDTOs = service.getHistory(login, pageable);

        return historyItemDTOs.getSize() == 0 ? new ResponseEntity<Page<HistoryItemDTO>>(historyItemDTOs, HttpStatus.OK) : new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
    }
}
