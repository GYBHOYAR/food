package recipe.com.example.food;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Service.IngredientService;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.repository.IngredientRepository;

@SpringBootTest
public class IngredientExceptionTest {

	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	private Ingredient getIngredients() {
		Ingredient ingredient = new Ingredient();
	    
		
		HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("Lemon", "1 Dozon");
			temp.put("Suger", "50 gm");
			temp.put("Salt","10 gm");
		
		ingredient.setIngredientId(1);
	    ingredient.setIngredient(temp);
		 
		return ingredient;
	}
	
	@Test
	void AddIngredientTest() {
		assertThrows(ElementExistsException.class,()->ingredientService.addIngredients(getIngredients()));
	}
	
	@Test
	void GetIngredientTestException() {
		assertThrows(NoSuchElementFoundException.class,()->ingredientService.getIngredient(1000));
	}
	
	@Test
	void UpdateIngredientTestException() {
		assertThrows(NoSuchElementFoundException.class,()->ingredientService.updateIngredients(1000, getIngredients()));
	}
}
