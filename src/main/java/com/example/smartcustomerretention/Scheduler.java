package com.example.smartcustomerretention;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
@Component
public class Scheduler {
    @Scheduled(fixedRate = 60000) // it runs every minute. fixedRate is in milliseconds.
    public void schedulerSpring() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate scheduler:: " + strDate);
    }

    //temp api to call the scheduler api
    @GetMapping("/scheduler")
    public String scheduler(){
        Scheduler sch = new Scheduler();
        sch.schedulerSpring();
        return "started the scheduler";
    }
}
