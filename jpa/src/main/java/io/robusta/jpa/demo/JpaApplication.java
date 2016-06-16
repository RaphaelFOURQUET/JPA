package io.robusta.jpa.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.data.StaticData;
import io.robusta.jpa.demo.entities.Category;
import io.robusta.jpa.demo.entities.CategoryCollection;
import io.robusta.jpa.demo.entities.Product;
import io.robusta.jpa.demo.entities.ProductCollection;

public class JpaApplication {

	public static void main(String[] args) {

		EntityManagerFactory instance = Persistence.createEntityManagerFactory("fora");
		
		EntityManager em = instance.createEntityManager();
		
		System.out.println("##########Debut Tests##########");
		
		//Debut de transaction
		em.getTransaction().begin();
		
		//Premiers tests
		for(Category c : StaticData.categoryList)
			em.persist(c);
		
		StaticData.ketchup.setCategory(StaticData.fooding);
		for(Product p : StaticData.productList)
			em.persist(p);
		
		StaticData.ketchup.setCategory(StaticData.fooding);
		
		Category ketchupCategory = StaticData.ketchup.getCategory();
		int ketchupCatId = ketchupCategory.getId();
		
		System.out.println("##########Debut Tests##########");
		System.out.println("ketchupCategory : "+ketchupCategory);
		System.out.println("ketchupCatId : "+ketchupCatId);
		
		//Fin Transaction
		em.getTransaction().commit();
		
		
		//Debut de transaction
		em.getTransaction().begin();
		
		Category cat = em.find(Category.class, ketchupCatId);
		System.out.println("catName : "+cat.getName());
		//em.remove(cat);		//Secondary key binding problem
		
		for(ProductCollection prodC : StaticData.productCList)
			em.persist(prodC);
		
		for(CategoryCollection catC : StaticData.categoryCList)
			em.persist(catC);

		
		List<ProductCollection> foodingCProd = StaticData.foodingC.getProducts();
		foodingCProd.add(StaticData.ketchupC);
		foodingCProd.add(StaticData.cornflakesC);
		foodingCProd.add(StaticData.milkC);
		StaticData.premiumC.getProducts().add(StaticData.ketchupC);
		
		
		
		//Fin Transaction
		em.getTransaction().commit();
		
		//Debut de transaction
		em.getTransaction().begin();
		
		List<ProductCollection> cheaps = em.createQuery("Select p FROM ProductCollection p where p.price < 2", ProductCollection.class).getResultList();
		
		System.out.println("#############"+cheaps);
		
		List<ProductCollection> foodings = em.find(CategoryCollection.class, StaticData.foodingC.getId()).getProducts();
		
		System.out.println("#############"+foodings);
		
		
		//Fin Transaction
		em.getTransaction().commit();
		
		em.close();
		instance.close();
		
		
	}
}
