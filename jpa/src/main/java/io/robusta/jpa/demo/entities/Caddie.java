package io.robusta.jpa.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Caddie {

	@Id
	@GeneratedValue
	int id;
	
	@OneToMany(fetch=FetchType.EAGER)	//On charge les produits lorsque l'on fait une requete sur caddie
	@OrderBy("price")
	List<Product> products = new ArrayList<>();

	
	public void addProduct(Product product){
		this.products.add(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Caddie [id=" + id + ", products=" + products + "]";
	}
	
	
	
}
