package com.example.smartcustomerretention.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "heartbeat")
@EntityListeners(AuditingEntityListener.class)
public class Heartbeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

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
}
