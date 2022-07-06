package ayush.springframework.ayushdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class ProtoTypeBean {
    public ProtoTypeBean() {
        System.out.println("Creating a prototype bean !!!!!!!!!");
    }

    public String getMyScope(){
        return "I am prototype";
    }
}
