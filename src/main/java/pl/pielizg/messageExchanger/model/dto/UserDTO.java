package pl.pielizg.messageExchanger.model.dto;

import pl.pielizg.messageExchanger.model.dao.Subject;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */
public class UserDTO {

    private String name;
    private String surname;
    private String title;
    private String status;
    private long phoneNumber;
    private String login;
    private String password;
    private String createdBy;
    private List<GroupDTO> groupDTOs;


    public UserDTO(String name, String surname, String title, String status, long phoneNumber, String login, String password, String createdBy) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.createdBy = createdBy;
    }

    public UserDTO(String name, String surname, String title, String status, long phoneNumber, String login, String password, String createdBy,  List<GroupDTO> groupDTOs) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.groupDTOs = groupDTOs;
        this.login = login;
        this.password = password;
        this.createdBy = createdBy;
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<GroupDTO> getGroupDTOs() {
        return groupDTOs;
    }

    public void setGroupDTOs(List<GroupDTO> groupDTOs) {
        this.groupDTOs = groupDTOs;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
