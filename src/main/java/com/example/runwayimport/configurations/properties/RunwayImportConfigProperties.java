package com.example.runwayimport.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "server")
public class RunwayImportConfigProperties {
    
    private String url;

    public String getUrl() {
        return this.url;
    }

    public RunwayImportConfigProperties setUrl(final String url) {
        this.url = url;
        return this;
    }

}
