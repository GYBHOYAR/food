package recipe.com.example.food;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Exceptions.UserAlreadyExists;
//import recipe.com.example.food.Exceptions.UserException;
import recipe.com.example.food.Exceptions.UserNotFoundException;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.repository.UserRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	private user getUser() {
		user user = new user();
		
		user.setFirstName("Rakesh");
		user.setLastName("Mehta");
		user.setUserName("Rakesh123");
		user.setPassword("R123");
		user.setUserId(9);
		
		return user;
		
	}
	
	@Test
	void testAddUser() throws ElementExistsException {
		user user = getUser();
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.createUser(user, null));
		
	}
	
	@Test
	void testViewUser() throws  NoSuchElementFoundException {
		user user = getUser();
		when(userRepository.findByUserName(user.getUserName())).thenReturn(Optional.of(user));
		assertEquals(user,userService.getUser(user.getUserName()));
	}
	
	@Test
	void testDeleteUser() throws  NoSuchElementFoundException {
		user user = getUser();
		when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		userService.deleteUser(user.getUserId());
		verify(userRepository,times(1)).deleteById(9);
	}
	
	@Test
	void testUpdateUser() throws NoSuchElementFoundException {
		user user = getUser();
		user.setFirstName("Mukesh");
		user.setLastName("Ambani");
		when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		when(userRepository.save(user)).thenReturn(user);
		assertThat(userService.updateUser(9, user)).isEqualTo(user);
	}
	
	
}
