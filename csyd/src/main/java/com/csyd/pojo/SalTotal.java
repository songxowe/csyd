package com.csyd.pojo;

import java.io.Serializable;
import java.util.Date;

public class SalTotal implements Serializable{
    private static final long serialVersionUID = 1L;
    private Double sal;
    private Integer month;
    private String busStatus;
    private Date busTime;

    public SalTotal() {
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }

    public Date getBusTime() {
        return busTime;
    }

    public void setBusTime(Date busTime) {
        this.busTime = busTime;
    }
}
