package com.onevote.query.consumer;

import com.onevote.Constants;
import com.onevote.User;
import com.onevote.query.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


public class UserConsumer implements Consumer<User>{
    private final Logger logger = LoggerFactory.getLogger(com.onevote.query.config.Consumer.class);

    @Autowired
    UserRepository userRepository;

    @Override
    @KafkaListener(topics = Constants.USER_TOPIC, groupId = "group_id")
    public void consume(User user){
        logger.info(String.format("#### -> Consumed user -> %s", user.toString()));
        userRepository.save(user);
    }
}
