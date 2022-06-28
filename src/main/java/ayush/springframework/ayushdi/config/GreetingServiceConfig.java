package ayush.springframework.ayushdi.config;

import ayush.springframework.ayushdi.services.ConstructorGreetingService;
import ayush.springframework.ayushdi.services.PropertyInjectedGreetingService;
import ayush.springframework.ayushdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//We can remove the Service annotation which is dependent on Spring Stereotype as takes time.
//We can use java configuration
@Configuration
public class GreetingServiceConfig{
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

