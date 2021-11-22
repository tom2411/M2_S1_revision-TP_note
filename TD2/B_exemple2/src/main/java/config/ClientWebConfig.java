package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
    @Configuration
    @ComponentScan(basePackages = {"controllers"})
    public class ClientWebConfig implements WebMvcConfigurer {

        @Override
        public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
            viewResolverRegistry.jsp("/WEB-INF/views/",".jsp");
        }

     /*  @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }
*/

    }