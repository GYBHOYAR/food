package recipe.com.example.food.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import recipe.com.example.food.Exceptions.UserAlreadyExists;
import recipe.com.example.food.Exceptions.UserException;
import recipe.com.example.food.Exceptions.UserNotFoundException;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.entity.Role;

import recipe.com.example.food.entity.user;
import recipe.com.example.food.entity.userRole;
import recipe.com.example.food.utility.GlobalResources;

@RestController
@RequestMapping("/user")
@Api(value = "/user" ,tags = "recipe user management")

//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserController {
private Logger logger = GlobalResources.getLogger(UserController.class);
	
	
//@Autowired(required = true)
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	////////////////////////////////////////////////////////////////////////////////////
	//creating user
	
	
	@PostMapping("/add")
	@ApiOperation(value = "create user", notes = "Create new user" ,tags = {"user management"})
		@ApiResponses( value = {@ApiResponse(code = 200 ,message = "user created sucessfully"),
		@ApiResponse(code = 404 ,message = "Invalid data"),
		@ApiResponse(code = 200 ,message = "Internal server error")
	})
	
	
	public user createUser(@RequestBody user user) throws Exception {
		
		String methodName = "createUser()";
		logger.info(methodName + "called");
		
		//System.out.println(user.getUserName()+"  "+auth.getName());
		Set<userRole> roles = new HashSet<>();
	   Role role = new Role();
		role.setRoleId(20);
		role.setRoleName("Admin");
		
		userRole userRole = new userRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		return this.userService.createUser(user, roles);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/get/{username}")
	@ApiOperation(value = "get user", notes = "get user from database" ,tags = {"user management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "get operation sucessful sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public user getUser(@PathVariable("userName") String userName) throws UserException {
		
		String methodName = "getUser()";
		logger.info(methodName + "called");
		
		return this.userService.getUser(userName);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	@DeleteMapping("/delete/{userId}")
	@ApiOperation(value = "delete user", notes = "Delete user from database" ,tags = {"user management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "user deleted sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public user deleteUser(@PathVariable("userId") Integer userId) throws UserNotFoundException {
		
		String methodName = "deleteUser()";
		logger.info(methodName + "called");
		
		return this.userService.deleteUser(userId);
	}
	
	@PutMapping("/update/{userId}")
	@ApiOperation(value = "update user", notes = "Update user from database" ,tags = {"user management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "user updated sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
	})
	public user updateUser(@PathVariable("userId") Integer userId,@RequestBody user user) throws UserNotFoundException {
		
		String methodName = "updateUser()";
		logger.info(methodName + "called");
		
		return this.userService.updateUser(userId, user);
	}
	
	
	@GetMapping("/users")
	public List<user> getAllUsers() {
		
		String methodName = "getAllUsers()";
		logger.info(methodName + "called");
		
		return userService.findAllUsers();
		
		
	}
	 
}
