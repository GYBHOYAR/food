package recipe.com.example.food.Service;

import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Exceptions.RecipeAlreadyExistsException;
import recipe.com.example.food.Exceptions.RecipeIdNotFoundException;
import recipe.com.example.food.Exceptions.RecipeNameNotFoundException;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.entity.recipes;

@Service
public interface RecipeService {

	recipes createRecipe(recipes recipe) throws  ElementExistsException;

	recipes getRecipe(String recipeName) throws  NoSuchElementFoundException;

	recipes deleteRecipe(Integer recipeId) throws  NoSuchElementFoundException;

	recipes updateRecipe(Integer recipeId, recipes recipe) throws  NoSuchElementFoundException;

	

}
