package basics.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CART")
public class Cart {

	@Id
	@Column(name = "ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "USER_NAME")
	private User user;

	@Column(name = "FRUITS")
	@OneToMany
	@JoinTable(name = "FRUIT", joinColumns = @JoinColumn(name = "FRUIT_NAME"))
	private Set<Fruit> fruits;
	@Column(name = "VEGETABLES")
	@OneToMany
	@JoinTable(name = "VEGETABLE", joinColumns = @JoinColumn(name = "VEGETABLE_NAME"))
	private Set<Vegetable> vegetables;
	@Column(name = "GROCERIES")
	@OneToMany
	@JoinTable(name = "GROCERY", joinColumns = @JoinColumn(name = "GROCERY_NAME"))
	private Set<Grocery> groceries;

	public Cart() {

	}

	public Cart(Cart cart) {
		this.fruits = cart.fruits;
		this.vegetables = cart.vegetables;
		this.id = cart.id;
		this.groceries = cart.groceries;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(Set<Fruit> fruits) {
		this.fruits = fruits;
	}

	public Set<Vegetable> getVegetables() {
		return vegetables;
	}

	public void setVegetables(Set<Vegetable> vegetables) {
		this.vegetables = vegetables;
	}

	public Set<Grocery> getGroceries() {
		return groceries;
	}

	public void setGroceries(Set<Grocery> groceries) {
		this.groceries = groceries;
	}

}
