package recipe.com.example.food.Service.Simpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.UserAlreadyExists;
import recipe.com.example.food.Exceptions.UserException;
import recipe.com.example.food.Exceptions.UserNotFoundException;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.entity.userRole;
import recipe.com.example.food.repository.RoleRepository;
import recipe.com.example.food.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public user createUser(user user, Set<userRole> userRoles) throws UserAlreadyExists {
		Optional<user> optional = userRepository.findByUserName(user.getUserName());
		if(optional.isPresent()) {
			System.out.println("User is already present!!");
			throw new UserAlreadyExists("User is already present!!");
		}
		else 
			userRepository.save(user);
		return user;
	}

	@Override
	public user getUser(String userName) throws UserException {
		
		//user local =  this.userRepository.findByUserName(userName);
		Optional<user> optional = userRepository.findByUserName(userName);
		if(optional.isEmpty()) {
			throw new UserException("User not Exists");
		}
			user user = optional.get();
			return user;
		}
	

	@Override
	public user deleteUser(Integer userId) throws UserNotFoundException {
		Optional<user> optional = userRepository.findById(userId);
		
		if(optional.isEmpty()) {
			throw new UserNotFoundException("user with given Id doesnot exists") ;
		}
		user user = optional.get();
		userRepository.deleteById(userId);;
		return user;
	}

	@Override
	public user updateUser(Integer userId, user user ) throws UserNotFoundException{
		Optional<user> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			user temp = optional.get();
			temp.setFirstName(user.getFirstName());
			temp.setLastName(user.getLastName());
			temp.setUserName(user.getUserName());
			temp.setUserRole(user.getUserRole());
			temp.setPassword(user.getPassword());
			
			userRepository.save(temp);
			
		}
		else
			throw new UserNotFoundException("user with given Id does not exists") ;;
			return user;
	}

}
