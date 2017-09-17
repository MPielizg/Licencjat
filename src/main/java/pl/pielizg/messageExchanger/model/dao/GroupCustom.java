package pl.pielizg.messageExchanger.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Pielizg on 2017-09-14.
 */
@Entity
@Table(name = "custom_groups")
public class GroupCustom {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String login;
    @NotNull
    @ManyToOne
    private Subject subject;
    @NotNull
    private String createdBy;

    @ManyToMany
    private List<Group> groups;

    @ManyToMany
    private List<User> users;

    public GroupCustom(String name, String login, Subject subject, String createdBy, List<Group> groups, List<User> users) {
        this.name = name;
        this.login = login;
        this.subject = subject;
        this.createdBy = createdBy;
        this.groups = groups;
        this.users = users;
    }

    public GroupCustom(String name, String login, Subject subject, String createdBy, List<Group> groups) {
        this.name = name;
        this.login = login;
        this.subject = subject;
        this.createdBy = createdBy;
        this.groups = groups;
    }

    public GroupCustom(String name, String login, Subject subject, List<User> users, String createdBy) {
        this.name = name;
        this.login = login;
        this.subject = subject;
        this.createdBy = createdBy;
        this.users = users;
    }

    public GroupCustom(String name, String login, String createdBy) {
        this.name = name;
        this.login = login;
        this.createdBy = createdBy;
    }

    public GroupCustom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
