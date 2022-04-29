package recipe.com.example.food.Service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.UserException;
import recipe.com.example.food.Exceptions.UserNotFoundException;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.entity.userRole;

@Service
public interface UserService {
	
	public user createUser(user user,Set<userRole>userRole) throws Exception;
	
	public user getUser(String userName) throws UserException;

	public user deleteUser(Integer userId) throws UserNotFoundException;

	public user updateUser(Integer userId,user user) throws UserNotFoundException;

	public user RegisterUser(user user);

	public List<user> findAllUsers();

}
