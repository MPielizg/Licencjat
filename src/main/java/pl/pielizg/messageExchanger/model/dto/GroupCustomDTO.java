package pl.pielizg.messageExchanger.model.dto;

import java.util.List;

/**
 * Created by Pielizg on 2017-09-14.
 */
public class GroupCustomDTO {
    private String name;
    private String login;
    private SubjectDTO subjectDTO;
    private String createdBy;
    private List<GroupDTO> groupDTOs;
    private List<UserDTO> userDTOs;

    public GroupCustomDTO(String name, String login, SubjectDTO subjectDTO, String createdBy, List<GroupDTO> groupDTOs, List<UserDTO> userDTOs) {
        this.name = name;
        this.login = login;
        this.subjectDTO = subjectDTO;
        this.createdBy = createdBy;
        this.groupDTOs = groupDTOs;
        this.userDTOs = userDTOs;
    }

    public GroupCustomDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<GroupDTO> getGroupDTOs() {
        return groupDTOs;
    }

    public void setGroupDTOs(List<GroupDTO> groupDTOs) {
        this.groupDTOs = groupDTOs;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }


}
