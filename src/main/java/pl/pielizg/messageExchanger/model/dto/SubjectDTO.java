package pl.pielizg.messageExchanger.model.dto;

import pl.pielizg.messageExchanger.model.dao.User;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */
public class SubjectDTO {

    private String name;
    private List<GroupDTO> groupDTOs;

    public SubjectDTO(String name, List<GroupDTO> groupDTOs) {
        this.name = name;
        this.groupDTOs = groupDTOs;
    }

    public SubjectDTO(String name) {
        this.name = name;
    }

    public SubjectDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupDTO> getGroupDTOs() {
        return groupDTOs;
    }

    public void setGroupDTOs(List<GroupDTO> groupDTOs) {
        this.groupDTOs = groupDTOs;
    }
}
