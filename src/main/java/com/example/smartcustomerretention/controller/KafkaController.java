package com.example.smartcustomerretention.controller;

import com.example.smartcustomerretention.kafka.Producer;
import com.example.smartcustomerretention.models.Heartbeat;
import com.example.smartcustomerretention.models.User;
import com.example.smartcustomerretention.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private final Producer producer;
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Heartbeat> heartbeatKafkaTemplate;

    // User Kafka
    @PostMapping(value = "/publish/user")
    public void sendMessage(@RequestBody User user) {
        logger.info(String.format("#### -> Producing message -> %s", user.getUserName()));
        kafkaTemplate.send("user", user);
    }

    @KafkaListener(topics = "user", containerFactory = "userKafkaListenerContainerFactory")
    public User userListener(User user) {
        // process user message
        logger.info(String.format("#### -> consuming message -> %s", user.getUserName()));
        return userRepository.save(user);
    }

    // Heartbeat kafka
    @PostMapping(value = "/publish/heartbeat")
    public void sendMessage(@RequestBody Heartbeat heartbeat) {
        logger.info(String.format("#### -> Producing message for userID-> %s", heartbeat.getUserId()));
        heartbeatKafkaTemplate.send("heartbeat", heartbeat);
    }

    @KafkaListener(topics = "heartbeat", containerFactory = "userKafkaListenerContainerFactory")
    public String heartbeatListener(Heartbeat heartbeat) {
        // process heartbeat message
        logger.info(String.format("#### -> consuming message for userID-> %s", heartbeat.getUserId()));

        HeartbeatController hb = new HeartbeatController();
        hb.updateHeartbeat(heartbeat);
        return  "Message Consumed";
    }
}
