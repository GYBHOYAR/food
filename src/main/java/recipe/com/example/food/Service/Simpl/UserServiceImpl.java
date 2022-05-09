package recipe.com.example.food.Service.Simpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Exceptions.UserAlreadyExists;
//import recipe.com.example.food.Exceptions.UserException;
import recipe.com.example.food.Exceptions.UserNotFoundException;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.controller.UserController;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.entity.userRole;
import recipe.com.example.food.repository.RoleRepository;
import recipe.com.example.food.repository.UserRepository;
import recipe.com.example.food.utility.GlobalResources;

/**
 * @author HP
 *
 */
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

	
	/**
	 * method takes user entity as input,
	 * checks weather user with same userName present in database or not
	 * if user is not there then new user gets created
	 * is user with same user name is threr then exception is thrown
	 *
	 */
	@Override
	public user createUser(user user, Set<userRole> userRoles) throws ElementExistsException {
		
		String methodName = "createUser()";
		logger.info(methodName + "called");
		
		//changed here the repository method
		Optional<user> optional = userRepository.findByUserName(user.getUserName());
		if(optional.isPresent()) {
			System.out.println("this User is already present !!");
			throw new ElementExistsException("User is already present!!");
		}
		else 
			//user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		return user;
	}

	/**
	 * method takes username as input parameter ,
	 * checkes weather user is present in database
	 * if user is present returns user,
	 * idf user is not present returns exception
	 *
	 */
	@Override
	public user getUser(String userName) throws NoSuchElementFoundException {
		
		String methodName = "getUser()";
		logger.info(methodName + "called");
		Optional<user> optional = userRepository.findByUserName(userName);
		if(optional.isEmpty()) {
			throw new NoSuchElementFoundException("User does not Exists");
		}
		user user = optional.get();
			return user;
		}
	

	/**
	 * method takes userId as a input parameter
	 * checkes weather user is present in  database
	 * if user is present that user gets deleted
	 * else exception is thrown
	 *
	 */
	@Override
	public user deleteUser(Integer userId) throws NoSuchElementFoundException {
		
		String methodName = "deleteUser()";
		logger.info(methodName + "called");
		
		Optional<user> optional = userRepository.findById(userId);
		
		if(optional.isEmpty()) {
			throw new  NoSuchElementFoundException ("user with given Id doesnot exists") ;
		}
		user user = optional.get();
		userRepository.deleteById(userId);;
		return user;
	}
	
	/**
	 * method takes user id and new user data as an input parameter,
	 * checkes weather user is present in database
	 * if user is present in database that user gets updated with new data,
	 * else exception is thrown 
	 *
	 */
	@Override
	public user updateUser(Integer userId, user user ) throws NoSuchElementFoundException{
		
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
			throw new  NoSuchElementFoundException 
				("user with given Id does not exists") ;;
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
	/**
	 *method returns list of all the users present in database
	 *
	 */
	@Override
	public List<user> findAllUsers() {
		
		String methodName = "getAllUsers()";
		logger.info(methodName + "called");
		
		List<user> list = userRepository.findAll();
		return list;
	}

}
