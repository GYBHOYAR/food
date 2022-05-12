package recipe.com.example.food;



import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Service.RecipeService;
import recipe.com.example.food.entity.Category;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.entity.recipes;
import recipe.com.example.food.repository.RecipeRepository;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
@SpringBootTest
public class recipesTest {

	@MockBean
	RecipeRepository recipeRepository;
	
	@Autowired
	RecipeService recipeService;
	
	private Ingredient getIngredient() {
		Ingredient ingredient = new Ingredient();
		ingredient.setIngredientId(10);
		return ingredient;
		
	}
	
	
	private recipes getRecipe() {
		recipes recipe = new recipes();
		
		recipe.setRecipeId(9);
		recipe.setRecipeName("Panir tikka");
		recipe.setServing(4);
		recipe.setInstructions("recipe for four prople");
		recipe.setCategory(Category.Vegetarian);
		recipe.setDate(LocalDate.now());
		 return recipe;
		 
		
	}
	
	@Test
	void testAddRecipe() throws ElementExistsException{
		recipes recipe = getRecipe();
		when(recipeRepository.save(recipe)).thenReturn(recipe);
		assertEquals(recipe,recipeService.createRecipe(recipe));
	}
	
	 
	@Test
	void GetRecipe() throws NoSuchElementFoundException{
		recipes recipe = getRecipe();
		
		String RecipeName = "Panir tikka";
		//int Id = 9;
		//Optional<recipes> recipe1 = recipeRepository.findByRecipeName(recipe.getRecipeName());
		when(recipeRepository.findByRecipeName("Panir tikka")).thenReturn(Optional.of(recipe));
		assertEquals(recipe,recipeService.getRecipe(recipe.getRecipeName()));
	}
	
	@Test
	void DeleteRecipe() throws NoSuchElementFoundException{
		recipes recipe = getRecipe();
	    when(recipeRepository.findById(9)).thenReturn(Optional.of(recipe));
	    recipeService.deleteRecipe(9);
	    verify(recipeRepository,times(1)).deleteById(9);
	    
	}
	
	@Test
	void UpdateRecipe() throws NoSuchElementFoundException {
		recipes recipe = getRecipe();
		recipe.setRecipeName("Chilli panir tikka");
		recipe.setInstructions("ABC");
		when(recipeRepository.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		//recipe.setRecipeName("Chilli panir tikka");
		//recipe.setInstructions("ABC");
		when(recipeRepository.save(recipe)).thenReturn(recipe);
		assertThat(recipeService.updateRecipe(9, recipe)).isEqualTo(recipe);
		//recipeRepository.save(recipe1);
		//recipeService.updateRecipe(9, recipe1);
		//verify(recipeRepository,times(1)).getById(9);
		//when(recipeRepository.save(recipe)).thenReturn(recipe)
		//assertThat(recipeService.updateRecipe(9, recipe)).
		//assertEquals(recipe1,recipeService.getRecipe("Chilli panir tikka"));
	}
}
