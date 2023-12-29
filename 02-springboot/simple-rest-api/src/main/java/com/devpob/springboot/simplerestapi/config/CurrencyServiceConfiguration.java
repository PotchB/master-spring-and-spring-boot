package com.devpob.springboot.simplerestapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 
 * <pre>
 * Binding:
 *      Mapped to application.properties
 *          currency-service.url=
 *          currency-service.username=
 *          currency-service.key=
 * </pre>
 */
@ConfigurationProperties(prefix="currency-service")     
/* 
    @ConfigurationPropertiesScan("com.devpob.springboot.simplerestapi.config")
    
    OR

    @EnableConfigurationProperties(CurrencyServiceConfiguration.class) 

    MUST be present in your class annotated with @SpringBootApplication
*/
// @Component   // This conflicts with the @ConfigurationProperties annotation
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public CurrencyServiceConfiguration(String url, String username, String key) {
        this.url = url;
        this.username = username;
        this.key = key;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}