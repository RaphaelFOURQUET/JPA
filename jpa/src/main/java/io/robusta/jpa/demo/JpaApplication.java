package io.robusta.jpa.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.entities.Category;
import io.robusta.jpa.demo.entities.Product;

public class JpaApplication {

	public static void main(String[] args) {

		//Category standard
		Product ketchup = new Product("Ketchup", 2.35f);
		Product watch = new Product("Watch", 19990f);
		Product milk = new Product("Milk", 1.15f);
		Product cornflakes = new Product("Corn Flakes", 1.55f);
		Product jeans = new Product("Jeans", 20.90f);
		Product shoes = new Product("Shoes", 15.00f);
		Product chair = new Product("Chair", 10.00f);
		Product hat = new Product("Hat", 70f);
		List<Product> productList = new ArrayList<>();
		productList.add(ketchup);
		productList.add(watch);
		productList.add(milk);
		productList.add(cornflakes);
		productList.add(jeans);
		productList.add(shoes);
		productList.add(chair);
		productList.add(hat);
		


		Category csp = new Category("CSP");
		Category luxe = new Category("luxory");
		Category premium = new Category("premium");
		Category standard = new Category("standard");
		Category lowcost = new Category("low-cost");
		Category fooding = new Category("fooding");
		
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(csp);
		categoryList.add(luxe);
		categoryList.add(premium);
		categoryList.add(standard);
		categoryList.add(lowcost);
		categoryList.add(fooding);
		
		
		
		EntityManagerFactory instance = Persistence.createEntityManagerFactory("fora");
		
		EntityManager em = instance.createEntityManager();
		
		//Debut de transaction
		em.getTransaction().begin();
		
		for(Category c : categoryList)
			em.persist(c);
		
		ketchup.setCategory(fooding);
		for(Product p : productList)
			em.persist(p);
		
		ketchup.setCategory(premium);
		
		//System.out.println("############"+ketchup.getClass().getCanonicalName());
		
		
		
		//Fin Transaction
		em.getTransaction().commit();
		
		em.close();
		instance.close();
		
		
	}
}
