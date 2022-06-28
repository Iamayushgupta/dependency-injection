package ayush.springframework.ayushdi.config;

import ayush.springframework.ayushdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

//We can remove the Service annotation which is dependent on Spring Stereotype as takes time.
//We can use java configuration
@Configuration
public class GreetingServiceConfig{
    @Profile("ES")
    @Bean("i18nService")  // Specifying the bean name as the qualifier name in I18nController
    I18nSpanishService i18nSpanishService(){
        return new I18nSpanishService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(){
        return new I18nEnglishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

}

