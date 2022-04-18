package recipe.com.example.food;

import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import recipe.com.example.food.Service.IngredientService;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.repository.IngredientRepository;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IngredientTest {
	
	@Autowired
	private IngredientService ingredientService;
	
	@MockBean
	private IngredientRepository ingredientRepository;

	private Ingredient getIngredients() {
		Ingredient ingredient = new Ingredient();
		
		HashMap<String,String> temp = new HashMap<String,String>();
			temp.put("Lemon", "1 Dozon");
			temp.put("Suger", "50 gm");
			temp.put("Salt","10 gm");
		
		ingredient.setIngredientId(9);
		
		 
		 ingredient.setIngredient(temp);
		 //ingredient.setIngredient);
		 
		 return ingredient;
	}
	
	@Test
	void TestAddIngredient() throws Exception{
		Ingredient ingredient = getIngredients();
		
		when(ingredientRepository.save(ingredient)).thenReturn(ingredient);
		assertEquals(ingredient,ingredientService.addIngredients(ingredient));
		//System.out.println(ingredientService.getIngredient(9) + "Add test ");
	}
	
	@Test
	void TestGetIngredient() throws Exception{
		Ingredient ingredient = getIngredients();
		System.out.println(ingredient.toString());
		//System.out.println(ingredientService.getIngredient(9));
		ingredientRepository.save(ingredient);
		ingredientService.addIngredients(ingredient);
		//Integer IngredientId = 9;
		when(ingredientRepository.findById(9)).thenReturn(Optional.of(ingredient));
		assertEquals(ingredient,ingredientService.getIngredient(9));
		
	}
	
	@Test
	void TestUpdateIngredient() throws Exception{
		Ingredient ingredient = getIngredients();
		HashMap<String,String> temp = new HashMap<String,String>();
		temp.put("orange", "1 Dozon");
		temp.put("brown Suger", "50 gm");
		temp.put("himalyan Salt","10 gm");
		
		ingredient.setIngredient(temp);
		
		
		ingredientService.addIngredients(ingredient);
		
		when(ingredientRepository.findById(ingredient.getIngredientId())).thenReturn(Optional.of(ingredient));
		when(ingredientRepository.save(ingredient)).thenReturn(ingredient);
		assertThat(ingredientService.updateIngredients(9, ingredient)).isEqualTo(ingredient);
	
	}
}
