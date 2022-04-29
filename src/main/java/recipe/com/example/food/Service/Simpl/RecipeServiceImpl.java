package recipe.com.example.food.Service.Simpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.RecipeAlreadyExistsException;
import recipe.com.example.food.Exceptions.RecipeIdNotFoundException;
import recipe.com.example.food.Exceptions.RecipeNameNotFoundException;
import recipe.com.example.food.Service.IngredientService;
import recipe.com.example.food.Service.RecipeService;
import recipe.com.example.food.controller.UserController;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.entity.recipes;
import recipe.com.example.food.repository.IngredientRepository;
import recipe.com.example.food.repository.RecipeRepository;
import recipe.com.example.food.utility.GlobalResources;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	private Logger logger = GlobalResources.getLogger(UserController.class);
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	//@Autowired
	//private IngredientRepository ingredientRepository;

	@Override
	public recipes createRecipe(recipes recipe) throws RecipeAlreadyExistsException {
		
		String methodName = "createRecipe()";
		logger.info(methodName + "called");
		
		
		Optional<recipes> optional = recipeRepository.findByRecipeName(recipe.getRecipeName());
		try {
			if(optional.isPresent()) {
				throw new RecipeAlreadyExistsException("recipe already exists");
			}
			else {
				 recipeRepository.save(recipe);
				
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipe;
		
	}

	@Override
	public recipes getRecipe(String recipeName) throws RecipeNameNotFoundException {
		
		String methodName = "getRecipe()";
		logger.info(methodName + "called");
		
		Optional<recipes> optional = recipeRepository.findByRecipeName(recipeName);
		if(optional.isEmpty()) {
			throw new RecipeNameNotFoundException("no recipe present with this name ");
		}
		recipes recipe = optional.get();
		return recipe;
		
	}

	@Override
	public recipes deleteRecipe(Integer recipeId) throws RecipeIdNotFoundException {
		
		String methodName = "deleteRecipe()";
		logger.info(methodName + "called");
		
		
		Optional<recipes> optional = recipeRepository.findById(recipeId);
		if(optional.isEmpty()) {
			throw new RecipeIdNotFoundException("recipe with id"+recipeId+"not present");
		} 
		else{
			recipeRepository.deleteById(recipeId);
		}
		recipes recipe = optional.get();
		return recipe;
	
	}

	@Override
	public recipes updateRecipe(Integer recipeId, recipes recipe) throws RecipeIdNotFoundException {
		
		String methodName = "updateRecepie()";
		logger.info(methodName + "called");
		
		Optional<recipes> optional = recipeRepository.findById(recipeId);
		if(optional.isPresent()) {
			recipes temp = optional.get();
			temp.setRecipeName(recipe.getRecipeName());
			temp.setServing(recipe.getServing());
			temp.setCategory(recipe.getCategory());
			temp.setRecipeId(recipe.getRecipeId());
			//temp.setInstructions(recipe.getInstructions());
			//temp.setIngredients(recipe.getIngredients());
			temp.setDate(recipe.getDate());
		}
		else throw new RecipeIdNotFoundException("recipe with id"+recipeId+"not present");
		return recipe;
	}

	
	
	

}
