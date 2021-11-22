package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.*;

@Configuration
public class ResourceAndBeanConfig {

    @Bean
    public Service1Impl1 service1Impl1() {
        return new Service1Impl1();
    }

    @Bean(value = "english")
    public Service1 service1() {
        return new Service1Impl2();
    }

    @Bean
    @Scope("prototype")
    public Service2 service2() {
        return new Service2Impl();
    }

    @Bean
    public Service3 service3() {
        Service3 service3=new Service3();
        service3.setService(service4());
        service3.setConseil(service6());
        return service3;
    }

    @Bean
    public Service4 service4() {
        return new Service4();
    }

    @Bean
    public Service5 service5() {
        return new Service5();
    }


    @Bean
    public Service6 service6() {
        return new Service6();
    }

    @Bean
    public Service7 service7() {
        return new Service7(service4(),service6());
    }

    @Bean
    public String motdujour() {
        return "Balivernes";
    }

}
