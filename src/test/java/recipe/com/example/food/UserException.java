package recipe.com.example.food;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.lang.reflect.Executable;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.hamcrest.CoreMatchers.is;
import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.advice.ControllerAdvice;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.repository.UserRepository;

@SpringBootTest
public class UserException {
	@Rule
	public ExpectedException exception = ExpectedException.none(); 

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	private user getUser() {
		user user = new user();
		
		user.setFirstName("Rakesh");
		user.setLastName("Mehta");
		user.setUserName("Maruti1234");
		user.setPassword("R123");		
		user.setUserId(9);
		
		return user;
		
	}
	
	@Test
	void addUserExceptionTest() {
		
		assertThrows(ElementExistsException.class,()->userService.createUser(getUser(), null));
		
		}
	
	@Test
	void getUserExceptionTest() {
		assertThrows(NoSuchElementFoundException.class,()->userService.getUser("Maruti12345"));
	}
	
	@Test
	void updateUserExceptionTest(){
		user user =  getUser();
		user.setFirstName("Anu");
		assertThrows(NoSuchElementFoundException.class,()->userService.updateUser(900, getUser()));
	}
	
	@Test
	void deleteUserExceptionTest() {
		assertThrows(NoSuchElementFoundException.class,()->userService.deleteUser(69));
	}
	
	
		
		
		
	
}
