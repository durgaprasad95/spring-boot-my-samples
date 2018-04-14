package basics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "VALUES")
public class Value {

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "QUANTITY")
	private String quantity;

	@Transient
	private String measuringScale;
	@Transient
	private int units;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String measuringScale, int units) {
		this.quantity = units + " " + measuringScale;
	}

}
