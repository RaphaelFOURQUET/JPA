package io.robusta.jpa.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.entities.Category;
import io.robusta.jpa.demo.entities.CategoryCollection;
import io.robusta.jpa.demo.entities.Product;
import io.robusta.jpa.demo.entities.ProductCollection;

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
		
		Category csp = new Category("CSP");
		Category luxe = new Category("luxory");
		Category premium = new Category("premium");
		Category standard = new Category("standard");
		Category lowcost = new Category("low-cost");
		Category fooding = new Category("fooding");
		
		//Creation de listes
		List<Product> productList = new ArrayList<>();
		productList.add(ketchup);
		productList.add(watch);
		productList.add(milk);
		productList.add(cornflakes);
		productList.add(jeans);
		productList.add(shoes);
		productList.add(chair);
		productList.add(hat);
		
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(csp);
		categoryList.add(luxe);
		categoryList.add(premium);
		categoryList.add(standard);
		categoryList.add(lowcost);
		categoryList.add(fooding);

		//par collection category -> produits
		ProductCollection ketchupC = new ProductCollection(ketchup);
		ProductCollection watchC = new ProductCollection(watch);
		ProductCollection milkC = new ProductCollection(milk);
		ProductCollection cornflakesC = new ProductCollection(cornflakes);
		ProductCollection jeansC = new ProductCollection(jeans);
		ProductCollection shoesC = new ProductCollection(shoes);
		ProductCollection chairC = new ProductCollection(chair);
		ProductCollection hatC = new ProductCollection(hat);
		
		CategoryCollection cspC = new CategoryCollection(csp);
		CategoryCollection luxeC = new CategoryCollection(luxe);
		CategoryCollection foodingC = new CategoryCollection(fooding);
		CategoryCollection premiumC = new CategoryCollection(premium);
		CategoryCollection standardC = new CategoryCollection(standard);
		CategoryCollection lowcostC = new CategoryCollection(lowcost);
		
		List<ProductCollection> productCList = new ArrayList<>();
		productCList.add(ketchupC);
		productCList.add(watchC);
		productCList.add(milkC);
		productCList.add(cornflakesC);
		productCList.add(jeansC);
		productCList.add(shoesC);
		productCList.add(chairC);
		productCList.add(hatC);
		
		List<CategoryCollection> categoryCList = new ArrayList<>();
		categoryCList.add(cspC);
		categoryCList.add(luxeC);
		categoryCList.add(premiumC);
		categoryCList.add(standardC);
		categoryCList.add(lowcostC);
		categoryCList.add(foodingC);
		
		
		
		
		EntityManagerFactory instance = Persistence.createEntityManagerFactory("fora");
		
		EntityManager em = instance.createEntityManager();
		
		System.out.println("##########Debut Tests##########");
		
		//Debut de transaction
		em.getTransaction().begin();
		
		//Premiers tests
		for(Category c : categoryList)
			em.persist(c);
		
		ketchup.setCategory(fooding);
		for(Product p : productList)
			em.persist(p);
		
		ketchup.setCategory(fooding);
		
		Category ketchupCategory = ketchup.getCategory();
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
		
		for(ProductCollection prodC : productCList)
			em.persist(prodC);
		
		for(CategoryCollection catC : categoryCList)
			em.persist(catC);

		
		List<ProductCollection> foodingCProd = foodingC.getProducts();
		foodingCProd.add(ketchupC);
		foodingCProd.add(cornflakesC);
		foodingCProd.add(milkC);
		premiumC.getProducts().add(ketchupC);
		
		
		
		//Fin Transaction
		em.getTransaction().commit();
		
		//Debut de transaction
		em.getTransaction().begin();
		
		List<ProductCollection> cheaps = em.createQuery("Select p FROM ProductCollection p where p.price < 2", ProductCollection.class).getResultList();
		
		System.out.println("#############"+cheaps);
		
		List<ProductCollection> foodings = em.find(CategoryCollection.class, foodingC.getId()).getProducts();
		
		System.out.println("#############"+foodings);
		
		
		//Fin Transaction
		em.getTransaction().commit();
		
		em.close();
		instance.close();
		
		
	}
}
