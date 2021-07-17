package  com.training.demo.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableAutoConfiguration
public class CorsConfig extends WebMvcConfigurationSupport {


    @Autowired
    Environment environment;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns(environment.getProperty("allowedOrigins"))
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Authorization", "Content-Type", "Accept", "X-Requested-With", "Origin",
                        "Access-Control-Request-Method", "Access-Control-Request-Headers", "X-TenantID")
                .exposedHeaders("Access-Control-Allow-Credentials").allowCredentials(true).maxAge(3600);
    }
}