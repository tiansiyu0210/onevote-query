package com.onevote.query.demo;


import com.onevote.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    UserRepository userRepository;

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(User user) throws IOException {
        logger.info(String.format("#### -> Consumed user -> %s", user.toString()));
        userRepository.save(user);
    }
}