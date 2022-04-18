package recipe.com.example.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recipe.com.example.food.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

	

}
