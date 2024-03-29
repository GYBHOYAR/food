package recipe.com.example.food.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.regex.*;
import static com.google.common.base.Predicates.or;
import javax.servlet.ServletContext;

@EnableSwagger2
@Configuration
public class swaggerConfig {
	 
	
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("recipe.com.example.food"))
	                .paths(postPaths())
	                .build();
	        //paths(PathSelectors.ant("/ingredient.*"))
	      //.paths(regex("/user.*"))
            //.paths(regex("/ingredient.*"))
            //.paths(regex("/recipe.*"))
	    }

	private Predicate<String> postPaths() {
		// TODO Auto-generated method stub
		return or(regex("/user.*"),regex("/recipe.*"),regex("/ingredient.*"));
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("recipe application services")
				.description("Documentetion generated using swagger 2").build();
	}
}
    
	

        
    

