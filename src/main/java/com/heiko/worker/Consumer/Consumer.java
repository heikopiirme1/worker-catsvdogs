package com.heiko.worker.Consumer;


import com.heiko.worker.Service.VotingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    VotingService votingService;

    @RabbitListener(queues="${rabbitmq.queue}")
    public void receivedMessage(String msg) {
        System.out.println("Received message: " + msg);
        votingService.giveVote(msg);
    }
}
