package pl.pielizg.messageExchanger.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;
    @NotNull
    private String surname;
    private String title;
    @NotNull
    private String status;
    @NotNull
    @Column(unique = true)
    private long phoneNumber;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String password;
    private String createdBy;

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;

    @ManyToMany(mappedBy = "users")
    private List<GroupCustom> groupCustoms;

    public User(String name, String surname, String title, String status, long phoneNumber, String login, String password, String createdBy, List<Group> groups, List<GroupCustom> groupCustoms) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.createdBy = createdBy;
        this.groups = groups;
        this.groupCustoms = groupCustoms;
    }

    public User(String name, String surname, String title, String status, long phoneNumber, String login, String password, String createdBy) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.createdBy = createdBy;
    }

    public User() {
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
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

    public List<GroupCustom> getGroupCustoms() {
        return groupCustoms;
    }

    public void setGroupCustoms(List<GroupCustom> groupCustoms) {
        this.groupCustoms = groupCustoms;
    }
}
