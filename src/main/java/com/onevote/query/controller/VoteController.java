package com.onevote.query.controller;

import com.onevote.Vote;
import com.onevote.query.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/votes")
public class VoteController {

    @Autowired
    VoteRepository voteRepository;



    @RequestMapping(method = RequestMethod.GET)
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Vote getVoteById(@PathVariable String id) {
        return voteRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("vote not found for id : " + id));
    }

}
