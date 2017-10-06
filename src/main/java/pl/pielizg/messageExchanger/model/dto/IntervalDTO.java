package pl.pielizg.messageExchanger.model.dto;

import java.util.Date;

/**
 * Created by Pielizg on 2017-10-06.
 */
public class IntervalDTO {
    private Date startDate;
    private Date endDate;

    public IntervalDTO(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public IntervalDTO() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
