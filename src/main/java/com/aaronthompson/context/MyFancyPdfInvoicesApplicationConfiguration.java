package com.aaronthompson.context;

import com.aaronthompson.ApplicationLauncher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
//@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties"
//        , ignoreResourceNotFound = true)
@EnableWebMvc
public class MyFancyPdfInvoicesApplicationConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
