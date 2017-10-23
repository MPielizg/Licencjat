package pl.pielizg.messageExchanger.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Pielizg on 2017-09-19.
 */
@Entity
@Table(name = "history_items")
public class HistoryItem {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String origin;
    @NotNull
    private String destination;
    @NotNull
    private Date date;

    private String message;
    @NotNull
    private boolean wasSend;

    @OneToMany(mappedBy = "historyItem")
    private List<Unsend> unsends;

    public HistoryItem(String origin, String destination, String message, Date date, boolean wasSend) {
        this.origin = origin;
        this.destination = destination;
        this.message = message;
        this.date = date;
        this.wasSend = wasSend;
    }

    public HistoryItem(String origin, String destination, String message, Date date, boolean wasSend, List<Unsend> unsends) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.message = message;
        this.wasSend = wasSend;
        this.unsends = unsends;
    }

    public HistoryItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isWasSend() {
        return wasSend;
    }

    public void setWasSend(boolean wasSend) {
        this.wasSend = wasSend;
    }

    public List<Unsend> getUnsends() {
        return unsends;
    }

    public void setUnsends(List<Unsend> unsends) {
        this.unsends = unsends;
    }
}
