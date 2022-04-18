package recipe.com.example.food.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.sun.istack.NotNull;

@Entity
@Table(name = "userRole")
public class userRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int userRoleId;
	
	public userRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userRole(int userRoleId, user user, Role role) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	@Override
	public String toString() {
		return "userRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	private user user;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
}
