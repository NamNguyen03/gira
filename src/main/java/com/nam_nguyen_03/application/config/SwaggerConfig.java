package com.nam_nguyen_03.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author nam
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nam_nguyen_03.application"))
				.build()
				.apiInfo(new ApiInfoBuilder().title("Gira Application")
						.version("1.0.0")
						.description("This project is used for education purpose only.")
						.contact( new Contact("Nam Nguyen", "https://www.blogducnam.com", "nam03031999@gmail.com"))
						.build());
	}



}
