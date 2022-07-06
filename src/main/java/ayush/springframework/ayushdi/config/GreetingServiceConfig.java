package ayush.springframework.ayushdi.config;

import ayush.springframework.ayushdi.datasource.FakeDataSource;
import ayush.springframework.ayushdi.repositories.EnglishGreetingRepository;
import ayush.springframework.ayushdi.repositories.EnglishGreetingRepositoryImpl;
import ayush.springframework.ayushdi.services.*;
import com.springframework.PetService;
import com.springframework.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//We can remove the Service annotation which is dependent on Spring Stereotype as takes time.
//We can use java configuration

//We can get rid of this annotation by defining our variables in application.propeties itself
//@PropertySource("classpath:datasource.properties")

@Configuration
public class GreetingServiceConfig{
    @Bean
    FakeDataSource fakeDataSource(@Value("${ayush.password}") String password ,
                                  @Value("${ayush.username}") String username,
                                  @Value("${ayush.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setJdbcurl(jdbcurl);
        fakeDataSource.setPassword(password);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Profile("ES")
    @Bean("i18nService")  // Specifying the bean name as the qualifier name in I18nController
    I18nSpanishService i18nSpanishService(){
        return new I18nSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
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

