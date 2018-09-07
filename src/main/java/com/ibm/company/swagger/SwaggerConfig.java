package com.ibm.company.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author saket
 *  Swagger configuration class
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();

	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Company Service")
				.description("Returns Company response from the database.")
				.contact("sakkashy@in.ibm.com").license("IBM Corportaion")
				.licenseUrl("sakkashy@in.ibm.com").version("1.0").build();
	}
	
	/**
	 * Change the regex to /. to register the actuator end points as well
	 * @return
	 */
	private Predicate<String> postPaths() {
		return or(regex("/company.*"));
	}
	
}
