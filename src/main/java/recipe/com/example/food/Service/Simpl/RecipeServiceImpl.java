package recipe.com.example.food.Service.Simpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
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

/**
 * @author Gunjan Bhoyar
 *
 */

@Service
public class RecipeServiceImpl implements RecipeService{
	
	private Logger logger = GlobalResources.getLogger(UserController.class);
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	/**
	 *This method takes entity body recipe ,
	 *method checks weather input body already in database or not,
	 *if recipe is not present in database it will add the given recipe body
	 *and returns the same,
	 *if recipe already exists exception thrown
	 */
	@Override
	public recipes createRecipe(recipes recipe) throws ElementExistsException {
		
		String methodName = "createRecipe()";
		logger.info(methodName + "called");
		
		Optional<recipes> optional = recipeRepository.findByRecipeName(recipe.getRecipeName());
		/*try {
			if(optional.isPresent()) {
				throw new ElementExistsException("recipe already exists");
			}
			else {
				 recipeRepository.save(recipe);
				
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(optional.isPresent()) {
			throw new ElementExistsException("recipe already exists");
		}
		else
		 recipeRepository.save(recipe);
		 //ingredientRepository.save(recipe.getIngredients());
		 return recipe;
		
	}

	/**
	 * this method takes recipe-name as input,
	 * method checks weather the recipe is present in database,
	 * if recipe present in database method returns recipe,
	 * if recipe not persent in database exception is thrown 
	 *
	 */
	@Override
	public recipes getRecipe(String recipeName) throws NoSuchElementFoundException {
		
		String methodName = "getRecipe()";
		logger.info(methodName + "called");
		
		Optional<recipes> optional = recipeRepository.findByRecipeName(recipeName);
		if(optional.isEmpty()) {
			throw new NoSuchElementFoundException("no recipe present with this name ");
		}
		recipes recipe = optional.get();
		return recipe;
		
	}
	
	/**
	 * This method takes recipe id as an input ,
	 * checks weather recipe is present or not,
	 * if recipe is present in database ,recipe gets deleted
	 * if recipe is not present exception is thrown
	 * 
	 *
	 */

	@Override
	public recipes deleteRecipe(Integer recipeId) throws NoSuchElementFoundException {
		
		String methodName = "deleteRecipe()";
		logger.info(methodName + "called");
		
		
		Optional<recipes> optional = recipeRepository.findById(recipeId);
		if(optional.isEmpty()) {
			throw new NoSuchElementFoundException("recipe with id"+recipeId+"not present");
		} 
		else{
			recipeRepository.deleteById(recipeId);
		}
		recipes recipe = optional.get();
		return recipe;
	
	}
	
	
	/**
	 * This method takes recipe id ,and updated recipe entity,
	 * checks weather recipe is present in database or not.
	 * if recipe is present ,it updated with new data,
	 * if recipe not present exception is thrown
	 * 
	 *
	 */

	@Override
	public recipes updateRecipe(Integer recipeId, recipes recipe) throws NoSuchElementFoundException {
		
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
		else throw new NoSuchElementFoundException("recipe with id"+recipeId+"not present");
		return recipe;
	}

	
	
	

}
