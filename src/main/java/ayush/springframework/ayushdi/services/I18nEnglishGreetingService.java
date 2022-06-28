package ayush.springframework.ayushdi.services;

//Making this profile as default so no need of active profile now
public class I18nEnglishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello world --English";
    }
}
