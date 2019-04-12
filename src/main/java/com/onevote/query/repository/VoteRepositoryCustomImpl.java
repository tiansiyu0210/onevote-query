package com.onevote.query.repository;

import com.onevote.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoteRepositoryCustomImpl implements VoteRepositoryCustom<Vote> {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Vote updateVote(Vote vote) {
        mongoTemplate.save(vote);
        return vote;
    }
}
