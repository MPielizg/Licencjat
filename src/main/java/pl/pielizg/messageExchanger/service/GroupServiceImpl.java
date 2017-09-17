package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.Repository.GroupRepository;
import pl.pielizg.messageExchanger.Repository.SubjectRepository;
import pl.pielizg.messageExchanger.map.Mapper;
import pl.pielizg.messageExchanger.model.dao.Group;
import pl.pielizg.messageExchanger.model.dao.Subject;
import pl.pielizg.messageExchanger.model.dto.GroupDTO;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-29.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository repository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    Mapper mapper;

    @Override
    public GroupDTO findGroupByLogin(String login) {
        Group group = repository.findByLogin(login);

        return group != null ? mapper.map(group) : null;
    }

    @Override
    public List<GroupDTO> findGroupsBySubjectName(String name) {
        Subject subject = subjectRepository.findByName(name);
        List<GroupDTO> groupDTOs = mapper.map(subject.getGroups());

        return groupDTOs;
    }
}
