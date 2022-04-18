package recipe.com.example.food.Service;

import org.springframework.stereotype.Service;

import recipe.com.example.food.entity.Ingredient;

@Service
public interface IngredientService {

	Ingredient addIngredients(Ingredient ingredient) throws Exception;

	Ingredient updateIngredients(Integer ingredientId, Ingredient ingredient) throws Exception;

	Ingredient getIngredient(Integer ingredientId) throws Exception;

}
