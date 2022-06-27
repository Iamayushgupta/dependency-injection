package ayush.springframework.ayushdi;

import ayush.springframework.ayushdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// Spring Does the component scan , whichever classes annotated with spring stereotypes gets picked up.
//Let's say if we move this class outside this package , it won't work because currently we are working on default
// component scan of spring

//We are over-riding the default component scan.
@ComponentScan(basePackages = {"com.springframework","ayush.springframework.ayushdi"})
@SpringBootApplication
public class AyushDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(AyushDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		MyController myController =(MyController) ctx.getBean("myController");
		System.out.println("--primary bean -----");
		System.out.println(myController.getGreeting());

		System.out.println("--------property--------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-----setter-----");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----constructor------");
		ConstructorInjectedController constructorInjectedController =(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		//Checking for active profiles
		System.out.println("--profiles--");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayGreeting());

	}
}
