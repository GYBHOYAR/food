package recipe.com.example.food.Service;

import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.entity.Ingredient;

@Service
public interface IngredientService {

	Ingredient addIngredients(Ingredient ingredient) throws ElementExistsException;

	Ingredient updateIngredients(Integer ingredientId, Ingredient ingredient) throws NoSuchElementFoundException ;

	Ingredient getIngredient(Integer ingredientId) throws NoSuchElementFoundException ;

}
