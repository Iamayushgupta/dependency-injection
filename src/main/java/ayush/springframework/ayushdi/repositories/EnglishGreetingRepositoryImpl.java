package ayush.springframework.ayushdi.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{

    @Override
    public String getGreeting() {
        return "Hello World -EN";
    }
}
