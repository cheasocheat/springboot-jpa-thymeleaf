package com.glf.test.glftest.webservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 11:33
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    /**
     *
     * @return
     */
    private ApiInfo metaData() {
        Contact contact = new Contact("Chea Socheat", "https://www.facebook.com/socheat.april", "soc.chea@gl-f.com");
        ApiInfo apiInfo = new ApiInfo(
                "API Document",
                "Web Service Document Testing",
                "1.0",
                "Terms of service",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
        return apiInfo;
    }
}
