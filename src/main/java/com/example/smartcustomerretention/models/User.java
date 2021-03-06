package com.example.smartcustomerretention.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

//Model class for user table with getter and setters
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_time", "userid"}, allowGetters = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false)
    private int userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "create_time")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
    private String createdTime;

    //userid
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //username
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //create_time
    public String getCreatedAt() {
        return createdTime;
    }

    public void setCreatedAt(String createdTime) {
        this.createdTime = createdTime;
    }
}
