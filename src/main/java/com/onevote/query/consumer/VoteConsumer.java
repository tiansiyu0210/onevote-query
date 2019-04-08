package com.onevote.query.consumer;

import com.onevote.User;
import com.onevote.event.VoteEvent;
import com.onevote.query.repository.UserRepository;
import com.onevote.query.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class VoteConsumer {

    private final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

    @Autowired
    VoteRepository voteRepository;

    @KafkaListener(topics = "vote", groupId = "group_id")
    public void consume(VoteEvent voteEvent) throws Exception {
        logger.info(String.format("#### -> Consumed vote event -> %s", voteEvent.toString()));
        switch (voteEvent.getAction()){
            case CREATE_VOTE: voteRepository.save(voteEvent.getVote()); break;
            case DELETE_VOTE: break;
            default: throw new Exception("no action matched");
        }
    }
}
