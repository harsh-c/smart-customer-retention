package com.example.smartcustomerretention.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// This table contains just the mapping of referred users.
// user id and referred id should match to a record in the user table

@Entity
@Table(name = "referraluser")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_time"}, allowGetters = true)
public class ReferralUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(name = "userid", nullable = false)
    int userId;

    @Column(name = "referreduseriD", nullable = false)
    int referredUserID;

    @Column(name = "create_time")
    private String createdTime;

    //getter
    public int getUserId() {
        return userId;
    }
    public int getReferredUserId() {
        return referredUserID;
    }
    public String getCreatedAt() {
        return createdTime;
    }

    // setter
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setReferredUserID(int referredUserID) {
        this.referredUserID = referredUserID;
    }

    public void setCreatedAt(String createdTime) {
        Price p = new Price();
        this.createdTime = p.currentTime();
    }
    public String currentTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }
}
