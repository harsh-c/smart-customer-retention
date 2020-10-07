package com.example.smartcustomerretention.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "heartbeat")
@EntityListeners(AuditingEntityListener.class)
public class Heartbeat {
    public Heartbeat(){}
    
    public Heartbeat(int id, int userId, int week, int month, int quarter, int sixMonth, int year, String lastUpdatedTime){
        this.userId = userId;
        this.week = week;
        this.month = month;
        this.quarter = quarter;
        this.sixMonth = sixMonth;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "userid", nullable = false)
    int userId;

    @Column(name = "week", nullable = false)
    int week;

    @Column(name = "month", nullable = false)
    int month;

    @Column(name = "quarter", nullable = false)
    int quarter;

    @Column(name = "6month", nullable = false)
    int sixMonth;

    @Column(name = "year", nullable = false)
    int year;

    @Column(name = "last_updated")
    private String lastUpdatedTime;

    // getter
    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }
    public int getWeek(){return week;}
    public int getMonth(){return month;}
    public int getQuarter(){return quarter;}
    public int getSixMonth(){return sixMonth;}
    public int getYear(){return year;}


    // setter
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setWeek(int week){this.week = week;}
    public void setMonth(int month){this.month = month;}
    public void setQuarter(int quarter){this.quarter = quarter;}
    public void setSixMonth(int sixMonth){this.sixMonth = sixMonth;}
    public void setYear(int year){this.year = year;}
    public void setLastUpdatedTime(String createdTime) {
        Heartbeat h = new Heartbeat();
        this.lastUpdatedTime = h.currentTime();
    }

    public String currentTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
}
