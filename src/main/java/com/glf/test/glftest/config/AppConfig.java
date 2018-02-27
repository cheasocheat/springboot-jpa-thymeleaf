package com.glf.test.glftest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:38
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }


    @Bean
    public HttpHeaders header() {
        HttpHeaders headers = new HttpHeaders();
        return  headers;
    }

}
