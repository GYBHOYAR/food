package recipe.com.example.food.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;


@Entity
@Table(name = "recipes")
public class recipes {
	
	@Id
	@Column(name = "RecipeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int recipeId;
	
	//@Column(name = "Recipe Name")
	@NotNull
	private String recipeName;
	
	//@Column(name = "instructions")
	@NotNull
	private String instructions;
	
	//@Column(name = "category")
	@NotNull
	private Category category;
	
	//@OneToMany
	//@JoinColumn(name = "RecipeId")
	//@Column
	//@ElementCollection
	//private HashMap<String,String> ingredient = new HashMap<String,String>();
	//@ElementCollection
	//private List<Ingredient> ingredient = new ArrayList<Ingredient>();
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	private  LocalDate Date;
	
	//@Column(name = "servings")
	@NotNull
	private int serving;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ingrediantId")
	private Ingredient ingredients;

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	

	public LocalDate getDate() {
		return Date;
	}

	/*public List<String> getIngredient() {
		return ingredient;
	}

	public void setIngredient(List<String> ingredient) {
		this.ingredient = ingredient;
	}*/

	public void setDate(LocalDate date) {
		Date = date;
	}

	/*public HashMap<String, String> getIngredient() {
		return (HashMap<String, String>) ingredient;
	}

	public void setIngredient(HashMap<String, String> ingredient) {
		this.ingredient = ingredient;
	}*/

	public int getServing() {
		return serving;
	}

	public void setServing(int serving) {
		this.serving = serving;
	}

	public recipes() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "recipes [recipeId=" + recipeId + ", recipeName=" + recipeName + ", instructions=" + instructions
				+ ", category=" + category + ", Date=" + Date + ", serving=" + serving + ", ingredients=" + ingredients
				+ "]";
	}

	public recipes(int recipeId, String recipeName, String instructions, Category category, LocalDate date, int serving,
			Ingredient ingredients) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.instructions = instructions;
		this.category = category;
		Date = date;
		this.serving = serving;
		this.ingredients = ingredients;
	}

	public Ingredient getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredient ingredients) {
		this.ingredients = ingredients;
	}

	
	

	/*@Override
	public String toString() {
		return "recipes [recipeId=" + recipeId + ", recipeName=" + recipeName + ", instructions=" + instructions
				+ ", category=" + category + ", ingredient=" + ingredient + ", Date=" + Date + ", serving=" + serving
				+ "]";
	}*/

	/*public recipes(int recipeId, String recipeName, String instructions, Category category, List<String> ingredient,
			LocalDate date, int serving) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.instructions = instructions;
		this.category = category;
		this.ingredient = (HashMap<String, String>) ingredient;
		Date = date;
		this.serving = serving;
	}*/

	/*@Override
	public String toString() {
		return "recipes [recipeId=" + recipeId + ", recipeName=" + recipeName + ", instructions=" + instructions
				+ ", category=" + category + ", ingredient=" + ingredient + ", Date=" + Date + ", serving=" + serving
				+ "]";
	}*/
	
	
	
	
	
}
