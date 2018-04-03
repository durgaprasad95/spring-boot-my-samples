package basics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "AUTHORITY", length = 50)
	private String authority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_NAME")
	private User user;

	private static Long i = 0l;

	public Long getId() {
		return id;
	}

	public void setId() {
		this.id = ++i;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
