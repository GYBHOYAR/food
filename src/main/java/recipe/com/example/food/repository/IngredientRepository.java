package recipe.com.example.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recipe.com.example.food.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer>{

	Optional<Ingredient> findByIngredientId(int ingrediantId);


	

}
