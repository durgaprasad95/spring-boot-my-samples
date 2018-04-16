package basics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "VEGETABLES")
public class Vegetable {

	private @Transient int units;
	private @Transient String measuringScale;

	@SequenceGenerator(name = "generator", initialValue = 1)
	@GeneratedValue(generator = "generator")
	@Column(name = "ID")
	private Long id;

	@Id
	@Column(name = "VEGETABLE_NAME")
	private String name;

	@Column(name = "QUANTITY")
	private String quantity;

	@Column(name = "PRICE")
	private float price;

	public Vegetable() {

	}

	public Vegetable(Vegetable vegetable) {
		this.name = vegetable.name;
		this.quantity = vegetable.quantity;
		this.price = vegetable.price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(int units, String measuringScale) {
		this.quantity = units + " " + measuringScale;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}