package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.model.dao.Group;
import pl.pielizg.messageExchanger.model.dao.User;
import pl.pielizg.messageExchanger.model.dto.Container;
import pl.pielizg.messageExchanger.model.dto.GroupDTO;
import pl.pielizg.messageExchanger.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pielizg on 2017-08-21.
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private HistoryService historyService;


    @Override
    public Container setMessage(String message) {
        if(!message.matches("[0-9a-zA-Z]+#[0-9a-zA-Z]+#[0-9a-zA-Z]+")){
            return new Container("Źle skonstruowana wiadomość");
        }
        else {
            List<Long> phoneNumbers = new ArrayList<>();
            String[] tab = message.split("#");

            if (tab[0].matches("[0-9]+")) {                                                     //z arduino
                UserDTO userDTOtemp = userService.findByPhoneNumber(Long.parseLong(tab[0]));
                if(userDTOtemp == null){
                    return new Container("Brak numeru w bazie");
                }
                phoneNumbers.add(Long.parseLong(tab[0]));
                UserDTO userDTO = userService.findByLogin(tab[1]);

                if(userDTO == null){
                    GroupDTO groupDTO = groupService.findGroupByLogin(tab[1]);
                    if(groupDTO==null){
                        return new Container("Brak podanego loginu");
                    }
                    List<UserDTO> list = groupDTO.getUserDTOs();
                    for(UserDTO u: list){
                        phoneNumbers.add(u.getPhoneNumber());
                    }
                } else {
                    phoneNumbers.add(userDTO.getPhoneNumber());
                }
                historyService.newHistoryItem(userDTOtemp.getLogin(), tab[1], tab[2]);
                return new Container(phoneNumbers, tab[2]);
            } else {                                                                    //z aplikacji
                UserDTO originUser = userService.findByLogin(tab[0]);
                UserDTO userDTO = userService.findByLogin(tab[1]);

                if(userDTO == null){
                    GroupDTO groupDTO = groupService.findGroupByLogin(tab[1]);
                    if(groupDTO==null){
                        return new Container("Brak podanego loginu");
                    }
                    List<UserDTO> list = groupDTO.getUserDTOs();
                    for(UserDTO u: list){
                        phoneNumbers.add(u.getPhoneNumber());
                    }
                } else {
                    phoneNumbers.add(userDTO.getPhoneNumber());
                }
                historyService.newHistoryItem(tab[0], tab[1], tab[2]);
                
                return new Container(phoneNumbers, tab[2]);
            }

        }
    }
}
