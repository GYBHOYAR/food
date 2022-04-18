package recipe.com.example.food.Service.Simpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.IngredientAlreadyExistsException;
import recipe.com.example.food.Exceptions.IngredientIdNotFoundException;
import recipe.com.example.food.Service.IngredientService;
import recipe.com.example.food.entity.Ingredient;
import recipe.com.example.food.repository.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {
	 
    @Autowired
	private IngredientRepository ingredientRepository;

	@Override
	public Ingredient addIngredients(Ingredient ingredient) throws IngredientAlreadyExistsException{
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
		Optional<Ingredient> optional = ingredientRepository.
				findByIngredientId(ingredientId);
		if(optional.isEmpty()) {
			throw new IngredientIdNotFoundException("no ingredient present with this ingredient Id");
		}
		 
			Ingredient ingredient2 = optional.get();
		  return ingredient2;
		
		
	}

	

}
