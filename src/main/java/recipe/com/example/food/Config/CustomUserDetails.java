package recipe.com.example.food.Config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import recipe.com.example.food.entity.user;

public class CustomUserDetails implements UserDetails {
	
	//@Autowired(required = true)
	//private BCryptPasswordEncoder passwordEncoder;
	
	private static final long serialVersionUID = 1L;
	private user user;

	public CustomUserDetails(user user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(
				this.user.getUserRole().toUpperCase());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		//return passwordEncoder.encode(this.user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUserName();
		//return passwordEncoder.encode(user.getPassword());
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public user getUserDetails() {
		return user;
		
	}

}
