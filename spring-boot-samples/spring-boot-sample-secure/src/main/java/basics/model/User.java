package basics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

	@Column(name = "ID")
	private Long id;

	@Id
	@Column(name = "USER_NAME", length = 50)
	private String userName;

	@NotNull
	@Column(name = "PASSWORD", length = 50)
	private String password;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private boolean enabled;

	private static Long i = 0l;

	public Long getId() {
		return id;
	}

	public void setId() {
		this.id = ++i;
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

}
