package recipe.com.example.food.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Service.IngredientService;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.utility.GlobalResources;

@RestController
//@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	
	private Logger logger = GlobalResources.getLogger(UserController.class);
	
	@Autowired
	private IngredientService ingredientService;

	@PostMapping("/add")
	//@RequestMapping(value = "/add" , method = RequestMethod.POST)
	@ApiOperation(value = "create ingredient", notes = "Create new ingredient set" ,tags = {"Ingredient management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "Ingredient set created sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")})
	public Ingredient addIngredient(@RequestBody Ingredient ingredient) throws ElementExistsException {
		
		String methodName = "addIngredient()";
		logger.info(methodName + "called");
		
		
		return this.ingredientService.addIngredients(ingredient);
	}
	
	
	@PutMapping("/update/{ingredientId}")
	//@RequestMapping(value = "/update/{ingredientId}" , method = RequestMethod.PUT)
	@ApiOperation(value = "update ingredients", notes = "update ingredient from database" ,tags = {"Ingredient management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "update operation sucessful"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public Ingredient updateIngredient(@PathVariable int ingredientId,
			@RequestBody Ingredient ingredient) throws NoSuchElementFoundException {
		
		String methodName = "updateIngredient()";
		logger.info(methodName + "called");
		
		
		return this.ingredientService.updateIngredients(ingredientId,ingredient);
	}
	
	@GetMapping("/get/{ingredientId}")
	//@RequestMapping(value = "/get/{ingredientId}" , method = RequestMethod.GET)
	@ApiOperation(value = "get ingredient", notes = "get ingredient from database" ,tags = {"Ingredient management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "get operation sucessful"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public Ingredient getIngredient(@PathVariable int ingredientId) throws NoSuchElementFoundException {
		
		String methodName = "getIngrediet()";
		logger.info(methodName + "called");
		
		
		return this.ingredientService.getIngredient(ingredientId);
	}
}
