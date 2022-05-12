package recipe.com.example.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import recipe.com.example.food.entity.recipes;
import recipe.com.example.food.entity.user;


@Repository
public interface UserRepository extends JpaRepository<user,Integer>  {
	
	@Query("SELECT u FROM user u WHERE (u.userName) = :userName")
   public Optional<user> findByUserName(String userName);
    
    @Query("SELECT u FROM user u WHERE (u.userName) = :userName")
	public user getUserByUserName(String userName);

	//Optional<user> findByUserNamee(String userName);
	
	

}
