package recipe.com.example.food.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import recipe.com.example.food.Exceptions.RecipeAlreadyExistsException;
import recipe.com.example.food.Exceptions.RecipeIdNotFoundException;
import recipe.com.example.food.Exceptions.RecipeNameNotFoundException;
import recipe.com.example.food.Service.RecipeService;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.entity.recipes;
import recipe.com.example.food.utility.GlobalResources;

@RestController
//@Controller
@RequestMapping("/recipe")
public class recipeController {
	
	private Logger logger = GlobalResources.getLogger(UserController.class);
	
	@Autowired
	private RecipeService recipeService;
	
	@PostMapping("/add")
	//@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ApiOperation(value = "create reipe", notes = "Create new recipe" ,tags = {"recipe management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "recipe created sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public recipes createRecipe(@RequestBody recipes recipe ) throws ElementExistsException{
		
		String methodName = "createRecipe()";
		logger.info(methodName + "called");
		
		return this.recipeService.createRecipe(recipe);
		
	}
	
///////////////////////////////////////////////////////////////////////////	
	@GetMapping("/get/{recipeName}")
	//@RequestMapping(value = "/get/{recipeName}",method = RequestMethod.GET)
	@ApiOperation(value = "get recipe", notes = "get recipe from database" ,tags = {"recipe management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "get operation sucessful sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public recipes getRecipe(@PathVariable("recipeName") String recipeName) throws NoSuchElementFoundException {
		
		String methodName = "getRecipe()";
		logger.info(methodName + "called");
		
		return this.recipeService.getRecipe(recipeName);
	}
	
	
///////////////////////////////////////////////////////////////////////////////	

	@DeleteMapping("/delete/{recipeId}")
	//@RequestMapping(value = "/delete/{recipeName}",method = RequestMethod.DELETE)
	@ApiOperation(value = "delete recipe", notes = "Delete recipe from database" ,tags = {"recipe management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "user deleted sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public recipes deleteRecipe(@PathVariable("recipeId") Integer recipeId) throws NoSuchElementFoundException{
		
		String methodName = "deleteRecipe()";
		logger.info(methodName + "called");
		
		return this.recipeService.deleteRecipe(recipeId);
	}

//////////////////////////////////////////////////////////////////////////////////
	
	@PutMapping("/update/{recipeId}")
	//@RequestMapping(value = "/update/{recipeName}",method = RequestMethod.PUT)
	@ApiOperation(value = "update recipe", notes = "update recipe from database" ,tags = {"recipe management"})
	@ApiResponses( value = {@ApiResponse(code = 200 ,message = "user deleted sucessfully"),
	@ApiResponse(code = 404 ,message = "Invalid data"),
	@ApiResponse(code = 200 ,message = "Internal server error")
})
	public recipes updateRecepie(@PathVariable("recipeId") Integer recipeId, @RequestBody recipes recipe) 
			throws  NoSuchElementFoundException {
		
		String methodName = "updateRecepie()";
		logger.info(methodName + "called");
		
		return this.recipeService.updateRecipe(recipeId,recipe);
	}
	
}
