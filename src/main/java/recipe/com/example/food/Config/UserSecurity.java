package recipe.com.example.food.Config;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import recipe.com.example.food.repository.UserRepository;

@Component("userSecurity")
public class UserSecurity {

	private UserRepository userRepository;
	
public boolean hasUserId(Authentication authentication, Integer userId) {
		int userId1 = userRepository.getUserByUserName(authentication.getName()).getUserId();
		if(userId1==userId) {
			return true;
		}
		return false;

}
}
