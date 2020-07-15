package com.example.smartcustomerretention.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "price")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_time"}, allowGetters = true)
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "userid", nullable = false)
    int userId;

    @Column(name = "create_time")
    private String createdTime;

    // Update pricing for the user? Y/N
    @Column(name = "update_price")
    private String updatePrice;

    // time to next update on pricing in number of days
    @Column(name = "next_update")
    private int nextUpdate;

    // Current price of the user
    @Column(name = "current_price")
    private float currentPrice;

    // getter
    public int getUserId() {
        return userId;
    }
    public String getCreatedAt() {
        return createdTime;
    }
    public String getUpdatePrice() {
        return updatePrice;
    }
    public int getNextUpdate() { return nextUpdate; }
    public float getCurrentPrice() { return currentPrice; }

    // setter
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setCreatedAt(String createdTime) {
        Price p = new Price();
        this.createdTime = p.currentTime();
    }
    public void setUpdatePrice(String updatePrice) { this.updatePrice = updatePrice; }
    public void setNextUpdate(int nextUpdate) { this.nextUpdate = nextUpdate; }
    public void setCurrentPrice(float currentPrice) { this.currentPrice = currentPrice; }

    public String currentTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

}
