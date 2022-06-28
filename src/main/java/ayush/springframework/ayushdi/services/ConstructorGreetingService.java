package ayush.springframework.ayushdi.services;

public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello world --constructor";
    }
}
