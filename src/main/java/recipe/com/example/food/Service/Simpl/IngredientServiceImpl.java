package recipe.com.example.food.Service.Simpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.IngredientAlreadyExistsException;
import recipe.com.example.food.Exceptions.IngredientIdNotFoundException;
import recipe.com.example.food.Service.IngredientService;
import recipe.com.example.food.controller.UserController;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.repository.IngredientRepository;
import recipe.com.example.food.utility.GlobalResources;

@Service
public class IngredientServiceImpl implements IngredientService {
	
	private Logger logger = GlobalResources.getLogger(UserController.class);
	 
    @Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Ingredient addIngredients(Ingredient ingredient) throws IngredientAlreadyExistsException{
		
		String methodName = "addIngredient()";
		logger.info(methodName + "called");
		
		Optional<Ingredient> optional = ingredientRepository.
				findByIngredientId(ingredient.getIngredientId());
		try {
			if(optional.isPresent()) {
				throw new IngredientAlreadyExistsException("ingredient already exists");
			}
			else
				return ingredientRepository.save(ingredient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ingredient ingredient1 = optional.get();
		return ingredient;
	}

	@Override
	public Ingredient updateIngredients(Integer ingredientId, Ingredient ingredient) throws IngredientIdNotFoundException {
		
		String methodName = "updateIngredient()";
		logger.info(methodName + "called");
		
		Optional<Ingredient> optional = ingredientRepository.
				findByIngredientId(ingredientId);
		if(optional.isPresent()){
			Ingredient temp = optional.get();
			temp.setIngredient(ingredient.getIngredient());
		}
//		else
//			if(optional.isEmpty()){
//				Ingredient temp = optional.get();
//				temp.setIngredient(ingredient.getIngredient());
//			}
		else 
				throw new IngredientIdNotFoundException("no ingredient present with this ingredient Id");
		return ingredient;
		
	}

	@Override
	public Ingredient getIngredient(Integer ingredientId) throws IngredientIdNotFoundException {
		
		String methodName = "getIngrediet()";
		logger.info(methodName + "called");
		
		Optional<Ingredient> optional = ingredientRepository.
				findByIngredientId(ingredientId);
		if(optional.isEmpty()) {
			throw new IngredientIdNotFoundException("no ingredient present with this ingredient Id");
		}
		 
			Ingredient ingredient2 = optional.get();
		  return ingredient2;
		
		
	}

	

}
