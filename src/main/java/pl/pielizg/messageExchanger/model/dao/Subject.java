package pl.pielizg.messageExchanger.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Pielizg on 2017-08-18.
 */
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<Group> groups;

    @OneToMany(mappedBy = "subject")
    private List<GroupCustom> groupCustoms;

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<GroupCustom> getGroupCustoms() {
        return groupCustoms;
    }

    public void setGroupCustoms(List<GroupCustom> groupCustoms) {
        this.groupCustoms = groupCustoms;
    }
}
