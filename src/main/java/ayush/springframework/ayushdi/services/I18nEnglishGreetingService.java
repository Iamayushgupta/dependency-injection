package ayush.springframework.ayushdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//Making this profile as default so no need of active profile now
@Profile({"EN" , "default"})
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello world --English";
    }
}
