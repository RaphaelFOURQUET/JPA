package io.robusta.jpa.demo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.entities.Category;
import io.robusta.jpa.demo.entities.Product;

public class JpaApplication {

	public static void main(String[] args) {

		//Category standard
		Product ketchup = new Product("Ketchup Tomato Heinz", 2.35f);
		Product watch = new Product("Watch", 19990f);
		Product milk = new Product("Milk", 1.15f);
		Product cornflakes = new Product("Corn Flakes", 1.55f);
		Product jeans = new Product("Jeans", 20.90f);
		Product shoes = new Product("Shoes", 15.00f);
		Product chair = new Product("Chair", 10.00f);
		Product hat = new Product("Hat", 70f);


		Category csp = new Category("CSP");
		Category luxe = new Category("luxory");
		Category premium = new Category("premium");
		Category standard = new Category("standard");
		Category lowcost = new Category("low-cost");
		Category fooding = new Category("fooding");
		
		
		EntityManagerFactory instance = Persistence.createEntityManagerFactory("fora");
	
		
		
	}
}
