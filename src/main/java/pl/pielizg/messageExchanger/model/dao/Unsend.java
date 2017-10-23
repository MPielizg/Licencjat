package pl.pielizg.messageExchanger.model.dao;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by Pielizg on 2017-10-23.
 */
@Entity
@Table(name = "unsend_to")
public class Unsend {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private Long phone_number;

    @ManyToOne
    private HistoryItem historyItem;

    public Unsend(Long phone_number) {
        this.phone_number = phone_number;
    }

    public Unsend() {
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public HistoryItem getHistoryItem() {
        return historyItem;
    }

    public void setHistoryItem(HistoryItem historyItem) {
        this.historyItem = historyItem;
    }

    public int getId() {
        return id;
    }
}
