package pl.pielizg.messageExchanger.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Pielizg on 2017-09-19.
 */
public class HistoryItemDTO {
    private int id;

    private String origin;

    private String destination;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String message;

    public HistoryItemDTO(int id, String origin, String destination, Date date, String message) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.message = message;
    }

    public HistoryItemDTO() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
