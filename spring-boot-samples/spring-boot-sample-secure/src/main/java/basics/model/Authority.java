package basics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {

	@Column(name = "ID")
	@Id
	@SequenceGenerator(name = "auto-generator", initialValue = 1)
	@GeneratedValue(generator = "auto-generator")
	private Long id;

	@Column(name = "ROLES", length = 50)
	@Length(min = 9, max = 20, message = "must be either ROLE_USER or ROLE_ADMIN")
	private String roles;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_NAME")
	private User user;

	public Authority() {

	}

	public Authority(Authority authority) {
		this.roles = authority.roles;
		this.user = authority.user;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
