package com.demoSpringBoot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import java.util.Base64;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    public static String originalMsg;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message) {
        originalMsg = message;
        String encodedmsg = Base64.getEncoder().encodeToString(message.getBytes());
        jmsTemplate.convertAndSend(queue, encodedmsg);
        return "Published Successfully";
    }
}
