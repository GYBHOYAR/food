package recipe.com.example.food.Service.Simpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.UserAlreadyExists;
import recipe.com.example.food.Exceptions.UserException;
import recipe.com.example.food.Exceptions.UserNotFoundException;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.controller.UserController;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.entity.userRole;
import recipe.com.example.food.repository.RoleRepository;
import recipe.com.example.food.repository.UserRepository;
import recipe.com.example.food.utility.GlobalResources;

@Service
public class UserServiceImpl implements UserService {
	
	//new changes
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	/////
	
	private Logger logger = GlobalResources.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public user createUser(user user, Set<userRole> userRoles) throws UserAlreadyExists {
		
		String methodName = "createUser()";
		logger.info(methodName + "called");
		
		
		Optional<user> optional = userRepository.findByUserName(user.getUserName());
		if(optional.isPresent()) {
			System.out.println("User is already present!!");
			throw new UserAlreadyExists("User is already present!!");
		}
		else 
			//user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		return user;
	}

	@Override
	public user getUser(String userName) throws UserException {
		
		String methodName = "getUser()";
		logger.info(methodName + "called");
		
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
		
		String methodName = "deleteUser()";
		logger.info(methodName + "called");
		
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
		
		String methodName = "updateUser()";
		logger.info(methodName + "called");
		
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

	@Override
	public user RegisterUser(user user) {
		Optional<user> optional = userRepository.findById(user.getUserId());
		if(optional.isEmpty()) {
			user newUser = optional.get();
			newUser.setFirstName(user.getFirstName());
		}
		return user;
	}

	@Override
	public List<user> findAllUsers() {
		
		String methodName = "getAllUsers()";
		logger.info(methodName + "called");
		
		List<user> list = userRepository.findAll();
		return list;
	}

}
