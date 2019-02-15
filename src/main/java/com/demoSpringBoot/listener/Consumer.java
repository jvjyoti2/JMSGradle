package com.demoSpringBoot.listener;

import com.demoSpringBoot.resource.ProducerResource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Consumer {

    @JmsListener(destination = "publisher.queue")
    public void listener(String message) {
        System.out.println("Recieved Message: "+message);
        String decodedString = new String(Base64.getDecoder().decode(message));
        System.out.println(decodedString);
        if(ProducerResource.originalMsg.equals(decodedString))
        {
            System.out.println("Input text and Output text are same.");
        }
        else
        {
            System.out.println("Input text and Output text are different.");
        }


    }

}
