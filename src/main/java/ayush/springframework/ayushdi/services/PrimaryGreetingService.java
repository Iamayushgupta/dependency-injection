package ayush.springframework.ayushdi.services;

public class PrimaryGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello world -- From primary bean";
    }
}
