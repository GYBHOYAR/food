package recipe.com.example.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import recipe.com.example.food.entity.recipes;

@Repository
public interface RecipeRepository extends JpaRepository<recipes,Integer> {

	
	@Query("SELECT r FROM recipes r WHERE (r.recipeName) = :recipeName")
	Optional<recipes> findByRecipeName(@Param("recipeName")String recipeName);

}
