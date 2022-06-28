package ayush.springframework.ayushdi.services;

public class PropertyInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world --property";
    }
}
