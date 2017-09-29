package pl.pielizg.messageExchanger.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    public HistoryItem(String origin, String destination, String message, Date date, boolean wasSend) {
        this.origin = origin;
        this.destination = destination;
        this.message = message;
        this.date = date;
        this.wasSend = wasSend;
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
}
