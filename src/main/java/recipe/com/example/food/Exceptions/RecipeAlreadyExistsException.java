package recipe.com.example.food.Exceptions;

public class RecipeAlreadyExistsException extends Exception {

	public RecipeAlreadyExistsException(String message) {
		super(message);
	}

	public RecipeAlreadyExistsException() {
		super();
	}

	
}
