package pl.pielizg.messageExchanger.map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import pl.pielizg.messageExchanger.model.dao.*;
import pl.pielizg.messageExchanger.model.dto.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */
@Component
public class Mapper {

    public UserDTO map(User user){
        List<Group> groups = user.getGroups();
        List<GroupDTO> groupDTOs = new ArrayList<>();
        if (groups != null) {
            for(Group g: groups){
                Subject subject = g.getSubject();
                SubjectDTO subjectDTO = new SubjectDTO(subject.getName());
                GroupDTO groupDTO = new GroupDTO(g.getNumber(), g.getLogin(), subjectDTO);
                groupDTOs.add(groupDTO);
            }
            return new UserDTO(user.getName(), user.getSurname(), user.getTitle(), user.getStatus(), user.getPhoneNumber(), user.getLogin(), user.getPassword(), user.getCreatedBy() ,groupDTOs);
        }
        return new UserDTO(user.getName(), user.getSurname(), user.getTitle(), user.getStatus(), user.getPhoneNumber(), user.getLogin(), user.getPassword(), user.getCreatedBy());
    }

    public SubjectDTO map(Subject subject){
        List<Group> groups = subject.getGroups();
        List<GroupDTO> groupDTOs = new ArrayList<>();

        for(Group g: groups){
            List<User> users = g.getUsers();
            List<UserDTO> userDTOs = new ArrayList<>();
            for(User u: users){
                UserDTO userDTO = new UserDTO(u.getName(), u.getSurname(), u.getTitle(), u.getStatus(), u.getPhoneNumber(), u.getLogin(), u.getPassword(), u.getCreatedBy());
                userDTOs.add(userDTO);
            }
            GroupDTO groupDTO = new GroupDTO(g.getNumber(), userDTOs, new SubjectDTO(subject.getName()), g.getLogin());
            groupDTOs.add(groupDTO);
        }

        SubjectDTO subjectDTO = new SubjectDTO(subject.getName(), groupDTOs);

        return subjectDTO;
    }

    public GroupDTO map(Group group){
        Subject subject = group.getSubject();
        SubjectDTO subjectDTO = new SubjectDTO(subject.getName());
        List<User> users = group.getUsers();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User u: users){
            UserDTO userDTO = new UserDTO(u.getName(), u.getSurname(), u.getTitle(), u.getStatus(), u.getPhoneNumber(), u.getLogin(), u.getPassword(), u.getCreatedBy());
            userDTOs.add(userDTO);
        }
        return new GroupDTO(group.getNumber(), userDTOs, subjectDTO, group.getLogin());
    }

    public GroupCustomDTO map(GroupCustom groupCustom){
        SubjectDTO subjectDTO = new SubjectDTO(groupCustom.getSubject().getName());

        List<Group> groups = groupCustom.getGroups();
        List<GroupDTO> groupDTOs = new ArrayList<>();
        for(Group g: groups){
            groupDTOs.add(new GroupDTO(g.getNumber(), g.getLogin(), subjectDTO));
        }

        List<User> users = groupCustom.getUsers();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User u: users){
            userDTOs.add(new UserDTO(u.getName(), u.getSurname(), u.getTitle(), u.getStatus(), u.getPhoneNumber(), u.getLogin(), u.getPassword(), u.getCreatedBy()));
        }

        return new GroupCustomDTO(groupCustom.getName(), groupCustom.getLogin(), subjectDTO, groupCustom.getCreatedBy(), groupDTOs, userDTOs);
    }

     public HistoryItemDTO map(HistoryItem historyItem){
        return new HistoryItemDTO(historyItem.getId(), historyItem.getOrigin(), historyItem.getDestination(), historyItem.getDate(), historyItem.getMessage());
    }

    public GroupCustom map(GroupCustomDTO groupCustomDTO){
        GroupCustom groupCustom = new GroupCustom(groupCustomDTO.getName(), groupCustomDTO.getLogin(), groupCustomDTO.getCreatedBy());
        return groupCustom;
    }

    public User map(UserDTO userDTO){
        User user = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getTitle(), userDTO.getStatus(), userDTO.getPhoneNumber(), userDTO.getLogin(), userDTO.getPassword(), userDTO.getCreatedBy());
        return user;
    }

    public Page<UserDTO> map(Page<User> page){
        return page.map(new Converter<User, UserDTO>() {
            @Override
            public UserDTO convert(User user) {
                return map(user);
            }
        });
    }

    public Page<HistoryItemDTO> mapHistoryItemPage(Page<HistoryItem> page){
        return page.map(new Converter<HistoryItem, HistoryItemDTO>() {
            @Override
            public HistoryItemDTO convert(HistoryItem historyItem) {
                return map(historyItem);
            }
        });
    }

    public Page<SubjectDTO> mapSubjectPage(Page<Subject> page){
        return page.map(new Converter<Subject, SubjectDTO>() {
            @Override
            public SubjectDTO convert(Subject subject) {
                return map(subject);
            }
        });
    }

    public Subject map(SubjectDTO subjectDTO){
        Subject subject = new Subject(subjectDTO.getName());
        return subject;
    }

    public List<GroupDTO> map(List<Group> groups){
        List<GroupDTO> groupDTOs = new ArrayList<>();
        for (Group g: groups){
            groupDTOs.add(map(g));
        }
        return groupDTOs;
    }

}
