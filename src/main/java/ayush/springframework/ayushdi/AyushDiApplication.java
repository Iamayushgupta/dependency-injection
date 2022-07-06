package ayush.springframework.ayushdi;

import ayush.springframework.ayushdi.controllers.*;
import ayush.springframework.ayushdi.services.ProtoTypeBean;
import ayush.springframework.ayushdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//Since there are no components (@Service) in com.springframework since it is injected in java config
//We no longer need component scan
//@ComponentScan(basePackages = {"com.springframework","ayush.springframework.ayushdi"})
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

		//Singleton Bean
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		// Prototype Bean
		ProtoTypeBean protoTypeBean1 = ctx.getBean(ProtoTypeBean.class);
		System.out.println(protoTypeBean1.getMyScope());
		ProtoTypeBean protoTypeBean2 = ctx.getBean(ProtoTypeBean.class);
		System.out.println(protoTypeBean2.getMyScope());

		// We can in the output that constructor of singleton has only been called
		// once whereas constructor of prototype bean has been called twice
		// After initialisation first thing that run is the singleton bean constructor but only once in its lifetime

	}
}
