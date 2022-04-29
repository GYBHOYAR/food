package recipe.com.example.food.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import recipe.com.example.food.entity.user;
import recipe.com.example.food.repository.UserRepository;

@Service
public class userDetailServiceImpl implements UserDetailsService {

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user =  userRepository.getUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User could not found");		
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
		
	}

}
