package recipe.com.example.food;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertThrows;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Service.RecipeService;
import recipe.com.example.food.entity.Category;
import recipe.com.example.food.entity.recipes;
import recipe.com.example.food.repository.RecipeRepository;

@SpringBootTest
public class RecipeExceptionTest {
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	RecipeService recipeService;
	
	private recipes getRecipe() {
		recipes recipe = new recipes();
		
		recipe.setRecipeId(48);
		recipe.setRecipeName("Fried Rice");
		recipe.setServing(4);
		recipe.setInstructions("recipe for four prople");
		recipe.setCategory(Category.Vegetarian);
		recipe.setDate(LocalDate.now());
		 return recipe;
	}
	@Test
	void addRecipeTest()  {
		//recipeRepository.save(null);
		assertThrows(ElementExistsException.class,()->recipeService.createRecipe(getRecipe()));
	}
	
	@Test
	void getRecipeException() {
		assertThrows(NoSuchElementFoundException.class,()->recipeService.getRecipe("Chinese fried rice"));
	}
	
	@Test
	void deleteRecipeException() {
		assertThrows(NoSuchElementFoundException.class,()->recipeService.deleteRecipe(99));
	}

	
	
}
