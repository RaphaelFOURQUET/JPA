package io.robusta.jpa.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.entities.Product;

public class FetchCaddieApplication {

	public static void main(String[] args) {

		EntityManagerFactory instance = Persistence.createEntityManagerFactory("fora");

		EntityManager em = instance.createEntityManager();

		//Debut de transaction
		em.getTransaction().begin();

		
		String categoryName = em.find(Product.class, 9).getCategory().getName();
		
		System.out.println("################"+categoryName);

		//Fin Transaction
		em.getTransaction().commit();

		em.close();
		instance.close();

	}

}
