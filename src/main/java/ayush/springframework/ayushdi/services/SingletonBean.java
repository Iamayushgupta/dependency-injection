package ayush.springframework.ayushdi.services;

import org.springframework.stereotype.Component;

//We need not specify the kind of bean we are making cause singleton is default bean
@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Singleton bean being created");
    }

    public String getMyScope(){
        return "I am singleton";
    }
}
