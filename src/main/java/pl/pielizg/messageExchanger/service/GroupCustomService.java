package pl.pielizg.messageExchanger.service;

import pl.pielizg.messageExchanger.model.dto.GroupCustomDTO;

import java.util.List;

/**
 * Created by Pielizg on 2017-09-14.
 */
public interface GroupCustomService {
    void insertGroupCustom(GroupCustomDTO groupCustomDTO);

    List<GroupCustomDTO> findCustomGroups(String name, String login);
}
