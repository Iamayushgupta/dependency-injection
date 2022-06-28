package ayush.springframework.ayushdi.services;

public class SetterInjectedGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello -Setter";
    }
}
