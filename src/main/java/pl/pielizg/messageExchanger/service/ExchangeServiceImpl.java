package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.Repository.HistoryRepository;
import pl.pielizg.messageExchanger.Repository.UnsendRepository;
import pl.pielizg.messageExchanger.model.dao.Group;
import pl.pielizg.messageExchanger.model.dao.HistoryItem;
import pl.pielizg.messageExchanger.model.dao.Unsend;
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
    @Autowired
    private HistoryRepository repository;
    @Autowired
    private UnsendRepository unsendRepository;

    @Override
    public Container setMessage(String message) {
        if(!message.matches("[0-9a-zA-Z]+#[0-9a-zA-Z]+#[0-9a-zA-Z ]+")){
            return new Container("Źle skonstruowana wiadomość");
        }
        else {
            List<Long> phoneNumbers = new ArrayList<>();
            List<Unsend> unsends = new ArrayList<>();
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
                        unsends.add(new Unsend(u.getPhoneNumber()));
                    }
                } else {
                    phoneNumbers.add(userDTO.getPhoneNumber());
                    unsends.add(new Unsend(userDTO.getPhoneNumber()));
                }
                historyService.newHistoryItem(userDTOtemp.getLogin(), tab[1], tab[2], false, unsends);
                return new Container(phoneNumbers, tab[2]);
            } else {                                                                    //z aplikacji
                UserDTO originUser = userService.findByLogin(tab[0]);
                UserDTO userDTO = userService.findByLogin(tab[1]);

                if(userDTO == null && originUser == null){
                    GroupDTO groupDTO = groupService.findGroupByLogin(tab[1]);
                    if(groupDTO==null){
                        return new Container("Brak podanego loginu");
                    }
                    List<UserDTO> list = groupDTO.getUserDTOs();
                    for(UserDTO u: list){
                        phoneNumbers.add(u.getPhoneNumber());
                        unsends.add(new Unsend(u.getPhoneNumber()));
                    }
                } else {
                    phoneNumbers.add(userDTO.getPhoneNumber());
                    unsends.add(new Unsend(userDTO.getPhoneNumber()));
                }
                historyService.newHistoryItem(tab[0], tab[1], tab[2], false, unsends);
                
                return new Container(phoneNumbers, tab[2]);
            }

        }
    }

    @Override
    @Deprecated
    public List<Container> getUnsendMessages() {
        List<HistoryItem> historyItems = repository.findByWasSend(false);
        List<Container> containers = new ArrayList<>();
        for(HistoryItem h: historyItems){
            Container container = new Container();
            container.setPhoneNumbers(new ArrayList<Long>());
            UserDTO userDTO = userService.findByLogin(h.getDestination());
            if(userDTO != null){
                container.getPhoneNumbers().add(userDTO.getPhoneNumber());
                container.setMessage(h.getMessage());
                containers.add(container);
                h.setWasSend(true);
                repository.save(h);
            } else {
                GroupDTO groupDTO = groupService.findGroupByLogin(h.getDestination());
                if(groupDTO != null){
                    groupDTO.getUserDTOs().forEach(u -> {
                        container.getPhoneNumbers().add(u.getPhoneNumber());
                    });
                    container.setMessage(h.getMessage());
                    containers.add(container);
                    h.setWasSend(true);
                    repository.save(h);
                }
            }
        }
        return containers;
    }

    @Override
    public Container getUnsend() {
        HistoryItem historyItem = repository.findTop1ByWasSend(false);
        Container container = new Container();
        container.setPhoneNumbers(new ArrayList<Long>());

        if(historyItem != null){
            if(historyItem.getUnsends().size() > 1){
                container.setMessage(historyItem.getMessage());
                container.getPhoneNumbers().add(historyItem.getUnsends().get(0).getPhone_number());
                container.setMore(true);
                unsendRepository.delete(historyItem.getUnsends().get(0).getId());
                unsendRepository.delete(historyItem.getUnsends().get(0));
            }
            else if(historyItem.getUnsends().size() == 1){
                container.setMessage(historyItem.getMessage());
                container.getPhoneNumbers().add(historyItem.getUnsends().get(0).getPhone_number());
                container.setMore(false);
                historyItem.setWasSend(true);
                repository.save(historyItem);
                unsendRepository.delete(historyItem.getUnsends().get(0));
            }
            else {
                container.setMore(false);
                historyItem.setWasSend(true);
            }
        } else {
            container.setMore(false);
        }
        if(repository.findTop1ByWasSend(false) != null){
            container.setMore(true);
        }
        return container;
    }


}
