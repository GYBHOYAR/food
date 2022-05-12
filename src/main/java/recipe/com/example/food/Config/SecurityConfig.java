package recipe.com.example.food.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.models.HttpMethod;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	//@Autowired
	//UserDetailsService userDetailsService;
	/*@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
		
}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
				
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	

	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
		@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/recipe/**","/ingredient/**").hasRole("ADMIN")
		.antMatchers("/recipe/**","/ingredient/**").hasRole("CUSTOMER")
//		.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","USER")
//		.antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","USER")
		
		//.antMatchers(HttpMethod.GET,"/v1/users").hasAnyRole("ADMIN")
		//.antMatchers(HttpMethod.GET,"/v1/users/{userId}").access("@userSecurity.hasUserId(authentication,#userId)")
		;
		
		
	    http.cors().disable();
	http.csrf().disable();
		http.headers().frameOptions().disable();
		
		super.configure(http);
		
		
	}*/
		
//	
	
///////////////////////////second///////////////////////////////////////////////

	@Bean 
	public UserDetailsService getUserDetails() {
		return new userDetailServiceImpl();			
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean	
	public NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}


	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetails());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		}
	
	
	@Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override                                   
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**").hasAuthority("ADMIN").
		antMatchers("/recipe/**","/ingredient/**").hasRole("CUSTOMER")
		.antMatchers("/**").permitAll().and().formLogin();
		
		http.csrf().disable();
		
	super.configure(http);
	System.out.println("inside configure");
	}
	
//////////////////////////first//////////////////////////////////////////////////	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("username").password("password")
		.roles("Admin");
		

	}
		
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/user/*","/recipe/*","/ingredient/*").fullyAuthenticated().and()
		.httpBasic();
	}
	
	@Bean
	public static NoOpPasswordEncoder apasswordEncoder() {
	return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}*/

///////////////////////////////////////////////////
	
}                                                                                                                                               

