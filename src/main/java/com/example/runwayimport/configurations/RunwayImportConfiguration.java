package com.example.runwayimport.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RunwayImportConfiguration {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
