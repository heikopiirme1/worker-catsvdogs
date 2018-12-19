package com.heiko.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VotingService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void giveVote(String voteName){
        jdbcTemplate.update("UPDATE votes SET vote_count = vote_count + 1 WHERE vote_name = ?", voteName);
    }
}
