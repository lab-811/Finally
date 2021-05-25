package org.example.Islambek.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class IssuedEventHandler implements ApplicationListener<IssuedEvent> {
    @Override
    public void onApplicationEvent(IssuedEvent issuedEvent) {
        System.out.println("User  {id: " + issuedEvent.getUserId() + "} issued book  {id: " + issuedEvent.getBookId() + "}");
    }
}
