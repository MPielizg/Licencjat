package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.model.dao.Group;
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


    @Override
    public Container setMessage(String message) {
        if(!message.contains("#")){
            return new Container("Źle skonstruowana wiadomość");
        }
        else {
            List<Long> phoneNumbers = new ArrayList<>();
            String[] tab = message.split("#", 10);
            UserDTO userDTO = userService.findByLogin(tab[0]);

            if(userDTO == null){
                GroupDTO groupDTO = groupService.findGroupByLogin(tab[0]);
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

            return new Container(phoneNumbers, tab[1]);
        }
    }
}
