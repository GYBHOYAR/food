package recipe.com.example.food.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
public class user  {//implements UserDetails

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	@NotNull
	private int userId;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	private boolean enabled = true;
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public user(int userId, String userName, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;

	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<userRole> userRole = new HashSet<>();
	
	public Set<userRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<userRole> userRole) {
		this.userRole = userRole;
	}
	
	////////////////////////////////////////////////
	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * Set<Authority> set = new HashSet<>(); this.userRole.forEach(userRole ->{
	 * set.add(new Authority(userRole.getRole().getRoleName())); });
	 * 
	 * return null; }
	 * 
	 * @Override public String getUsername() { return userName; }
	 * 
	 * @Override public boolean isAccountNonExpired() { // TODO Auto-generated
	 * method stub return true; }
	 * 
	 * @Override public boolean isAccountNonLocked() { // TODO Auto-generated method
	 * stub return true; }
	 * 
	 * @Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
	 * method stub return true; }
	 * 
	 * @Override public boolean isEnabled() { // TODO Auto-generated method stub
	 * return true; }
	 */
	
}
