package recipe.com.example.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity
//@EnableSwagger2
//@ComponentScan("recipe.com.example.food.Service.UserService")
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//System.out.println(encoder.encode("ramesh"));
		//System.out.println(encoder.encode("Suresh"));
	}
	
	
}
