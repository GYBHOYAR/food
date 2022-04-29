package recipe.com.example.food.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ingredientId")
	private int ingredientId;
	
	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public HashMap<String, String> getIngredient() {
		return ingredient;
	}

	public void setIngredient(HashMap<String, String> ingredient) {
		this.ingredient = ingredient;
	}

	private HashMap<String ,String> ingredient = new HashMap<String,String>();
	//private int ingrediantId;

	public Ingredient(int ingredientId, HashMap<String, String> ingredient) {
		super();
		this.ingredientId = ingredientId;
		this.ingredient = ingredient;
	}

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ingredient [ingrediantId=" + ingredientId + ", ingredient=" + ingredient + "]";
	}
	
	@OneToOne
	public recipes recipes;
	
	
	
	/*@Column(name = "ingrediantName")
	private String ingrediantName;
	
@Column(name = "Quantity")
	private String quantity;

	public int getIngrediantId() {
		return ingrediantId;
	}

	public void setIngrediantId(int ingrediantId) {
		//this.ingrediantId = ingrediantId;
}

	public String getIngrediantName() {
		return ingrediantName;
	}

	public void setIngrediantName(String ingrediantName) {
		this.ingrediantName = ingrediantName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Ingredient [ingrediantId=" + ingrediantId + ", ingrediantName=" + ingrediantName + ", quantity="
				+ quantity + "]";
	}

	public Ingredient(int ingrediantId, String ingrediantName, String quantity) {
		super();
		this.ingrediantId = ingrediantId;
		this.ingrediantName = ingrediantName;
		this.quantity = quantity;
	}

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@ManyToOne
	//private recipes recipes;
*/

}
