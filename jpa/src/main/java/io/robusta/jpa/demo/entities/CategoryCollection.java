package io.robusta.jpa.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class CategoryCollection {
	//Do we need an int id ?
	@Id @GeneratedValue
	int id;
	
	String name;
	
	@ManyToMany
	List<ProductCollection> products = new ArrayList<>();

	public CategoryCollection() {

	}
	
	public CategoryCollection(Category c) {
		this.name = c.getName();
	}

	public CategoryCollection(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<ProductCollection> getProducts() {
		return products;
	}

	public void setProducts(List<ProductCollection> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return this.name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
