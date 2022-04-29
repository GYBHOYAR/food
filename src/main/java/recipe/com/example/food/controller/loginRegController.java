package recipe.com.example.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.entity.user;

@RestController

public class loginRegController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
    public user registerUser(@RequestBody user user) {
		
		return this.userService.RegisterUser(user);
	 
	 
 }
}
