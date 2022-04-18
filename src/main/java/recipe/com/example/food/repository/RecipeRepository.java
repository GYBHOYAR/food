package recipe.com.example.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recipe.com.example.food.entity.recipes;

@Repository
public interface RecipeRepository extends JpaRepository<recipes,Integer> {

	

	Optional<recipes> findByRecipeName(String recipeName);

}
