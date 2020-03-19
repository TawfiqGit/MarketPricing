package com.tmo.market;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

    @Bean
    public Docket marketApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() //initialiser une classe du nom de MarketApi
                .apis(RequestHandlerSelectors.basePackage("com.tmo.market")) //filtrer selon les contrôleurs return true ou false
              //  .paths(PathSelectors.regex("/market.*"))//accepte URI commençant par /Market
                .build()
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET,
                        singletonList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build())) //messages pour 500 error
         ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Market API")
                .description("Enregister les tarifs & Realiser un panier")
                .version("1.0")
                .contact(new Contact("Tawfiq","","tawfiq@gmail.com"))
                .build();
    }

}
