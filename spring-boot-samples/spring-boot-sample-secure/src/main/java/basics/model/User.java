package basics.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "USERS")
public class User {

	@Column(name = "ID")
	@SequenceGenerator(name = "auto-generator", initialValue = 1)
	@GeneratedValue(generator = "auto-generator")
	private Long id;

	@Id
	@Column(name = "USER_NAME")
	@Length(max = 50, message = "must be less than 50 characters")
	private String userName;

	@NotNull
	@Column(name = "PASSWORD")
	@Length(max = 70, message = "must be less than 70 characters")
	private String password;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private boolean enabled;

	@Transient
	private List<GrantedAuthority> roles;

	public User() {

	}

	public User(User user) {
		this.userName = user.userName;
		this.password = user.password;
		this.enabled = user.enabled;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setRoles(List<GrantedAuthority> roles) {
		this.roles = roles;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

}
