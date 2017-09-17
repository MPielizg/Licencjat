package pl.pielizg.messageExchanger.model.dto;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Pielizg on 2017-08-21.
 */
public class Container {
    private List<Long> phoneNumbers;
    private String message;

    public Container(List<Long> phoneNumbers, String message) {
        this.phoneNumbers = phoneNumbers;
        this.message = message;
    }

    public Container(String message) {
        this.message = message;
    }

    public Container() {
    }

    public List<Long> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
