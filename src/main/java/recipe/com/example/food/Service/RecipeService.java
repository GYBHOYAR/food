package recipe.com.example.food.Service;

import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.RecipeAlreadyExistsException;
import recipe.com.example.food.Exceptions.RecipeIdNotFoundException;
import recipe.com.example.food.Exceptions.RecipeNameNotFoundException;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.entity.recipes;

@Service
public interface RecipeService {

	recipes createRecipe(recipes recipe) throws RecipeAlreadyExistsException;

	recipes getRecipe(String recipeName) throws RecipeNameNotFoundException;

	recipes deleteRecipe(Integer recipeId) throws RecipeIdNotFoundException;

	recipes updateRecipe(Integer recipeId, recipes recipe) throws RecipeIdNotFoundException;

	

}
