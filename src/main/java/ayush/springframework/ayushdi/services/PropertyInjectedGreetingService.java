package ayush.springframework.ayushdi.services;

import org.springframework.stereotype.Service;

//@Service
public class PropertyInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world --property";
    }
}
