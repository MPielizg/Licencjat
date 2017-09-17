package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.Repository.GroupCustomRepository;
import pl.pielizg.messageExchanger.Repository.GroupRepository;
import pl.pielizg.messageExchanger.Repository.SubjectRepository;
import pl.pielizg.messageExchanger.Repository.UserRepository;
import pl.pielizg.messageExchanger.map.Mapper;
import pl.pielizg.messageExchanger.model.dao.Group;
import pl.pielizg.messageExchanger.model.dao.GroupCustom;
import pl.pielizg.messageExchanger.model.dao.Subject;
import pl.pielizg.messageExchanger.model.dao.User;
import pl.pielizg.messageExchanger.model.dto.GroupCustomDTO;
import pl.pielizg.messageExchanger.model.dto.GroupDTO;
import pl.pielizg.messageExchanger.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pielizg on 2017-09-14.
 */
@Service
public class GroupCustomServiceImpl implements GroupCustomService {

    @Autowired
    private Mapper mapper;
    @Autowired
    private GroupCustomRepository repository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void insertGroupCustom(GroupCustomDTO groupCustomDTO) {
        GroupCustom groupCustom = mapper.map(groupCustomDTO);
        groupCustom.setSubject(subjectRepository.findByName(groupCustomDTO.getSubjectDTO().getName()));

        List<User> userList = new ArrayList<>();
        for(UserDTO u: groupCustomDTO.getUserDTOs()) {
            userList.add(userRepository.findByPhoneNumber(u.getPhoneNumber()));
        }
        groupCustom.setUsers(userList);

        List<Group> groupList = new ArrayList<>();
        for(GroupDTO g: groupCustomDTO.getGroupDTOs()) {
            groupList.add(groupRepository.findByLogin(g.getLogin()));
        }
        groupCustom.setGroups(groupList);

        for(User u: groupCustom.getUsers()){
            u.getGroupCustoms().add(groupCustom);
        }
        for(Group g: groupCustom.getGroups()){
            g.getGroupCustoms().add(groupCustom);
        }

        userRepository.save(groupCustom.getUsers());
        groupRepository.save(groupCustom.getGroups());
        repository.save(groupCustom);
    }

    @Override
    public List<GroupCustomDTO> findCustomGroupsBySubjectName(String name) {
        Subject subject = subjectRepository.findByName(name);
        List<GroupCustomDTO> groupCustomDTOs = new ArrayList<>();

        for(GroupCustom g: subject.getGroupCustoms()){
            groupCustomDTOs.add(mapper.map(g));
        }

        return groupCustomDTOs;
    }
}
