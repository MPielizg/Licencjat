package pl.pielizg.messageExchanger.model.dto;

import java.util.Date;

/**
 * Created by Pielizg on 2017-10-06.
 */
public class IntervalDTO {
    private String startDate;
    private String endDate;

    public IntervalDTO(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public IntervalDTO() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
