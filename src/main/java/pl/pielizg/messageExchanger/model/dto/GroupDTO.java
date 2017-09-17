package pl.pielizg.messageExchanger.model.dto;

import pl.pielizg.messageExchanger.model.dao.Subject;
import pl.pielizg.messageExchanger.model.dao.User;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-22.
 */
public class GroupDTO {
    private int groupNumber;

    private String login;

    private List<UserDTO> userDTOs;

    private SubjectDTO subjectDTO;

    public GroupDTO(int groupNumber, List<UserDTO> userDTOs, SubjectDTO subjectDTO, String login) {
        this.groupNumber = groupNumber;
        this.userDTOs = userDTOs;
        this.subjectDTO = subjectDTO;
        this.login = login;
    }

    public GroupDTO(int groupNumber, String login, SubjectDTO subjectDTO) {
        this.groupNumber = groupNumber;
        this.login = login;
        this.subjectDTO = subjectDTO;
    }

    public GroupDTO() {
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
