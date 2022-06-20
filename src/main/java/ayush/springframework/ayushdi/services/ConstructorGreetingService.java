package ayush.springframework.ayushdi.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello world --constructor";
    }
}
