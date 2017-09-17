package pl.pielizg.messageExchanger.service;

import pl.pielizg.messageExchanger.model.dto.GroupDTO;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-29.
 */
public interface GroupService {
    GroupDTO findGroupByLogin(String login);

    List<GroupDTO> findGroupsBySubjectName(String name);
}
