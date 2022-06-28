package ayush.springframework.ayushdi.services;

import ayush.springframework.ayushdi.repositories.EnglishGreetingRepository;

//Making this profile as default so no need of active profile now
public class I18nEnglishGreetingService implements GreetingService{
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello world --English";
    }
}
