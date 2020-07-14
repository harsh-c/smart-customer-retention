package com.example.smartcustomerretention.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

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

//    @Column(name = "username", nullable = false)
//    String userName;
//
//    @Column(name = "referreduser", nullable = false)
//    String referredUser;

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

//    public String getUserName() {
//        return userName;
//    }
//    public String getReferredUserName() {
//        return referredUser;
//    }

    // setter
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setReferredUserID(int referredUserID) {
        this.referredUserID = referredUserID;
    }

    public void setCreatedAt(String createdTime) {
        this.createdTime = createdTime;
    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//    public void setReferredUserName(String referredUser) {
//        this.referredUser = referredUser;
//    }

}
