package pl.pielizg.messageExchanger.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Pielizg on 2017-08-22.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private int number;

    @NotNull
    private String login;

    @JoinColumn(name = "subject_id")
    @ManyToOne
    private Subject subject;

    @ManyToMany
    private List<User> users;

    @ManyToMany(mappedBy = "groups")
    private List<GroupCustom> groupCustoms;

    public Group(int number, Subject subject, String login) {
        this.number = number;
        this.subject = subject;
        this.login = login;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<GroupCustom> getGroupCustoms() {
        return groupCustoms;
    }

    public void setGroupCustoms(List<GroupCustom> groupCustoms) {
        this.groupCustoms = groupCustoms;
    }
}
