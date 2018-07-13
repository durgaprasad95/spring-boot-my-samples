package basics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRICES")
public class Value {

	@Id
	@Column(name = "VALUE_NAME")
	private String name;

	@NotNull
	@Column(name = "TYPE")
	private String type;

	@Column(name = "QUANTITY")
	private String quantity;

	@NotNull
	@Column(name = "AMOUNT")
	private int amount;

	@Transient
	private String measuringScale;
	@Transient
	private int units;

	public Value() {

	}

	public Value(String name, String type, String quantity, int amount) {
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.amount = amount;
	}

	public String getMeasuringScale() {
		return measuringScale;
	}

	public void setMeasuringScale(String measuringScale) {
		this.measuringScale = measuringScale;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
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

	public void setQuantity(String measuringScale, int units) {
		this.quantity = units + " " + measuringScale;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
