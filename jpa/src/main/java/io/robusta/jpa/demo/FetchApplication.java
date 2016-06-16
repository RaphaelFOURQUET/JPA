package io.robusta.jpa.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.entities.CategoryCollection;
import io.robusta.jpa.demo.entities.ProductCollection;

public class FetchApplication {

	public static void main(String[] args) {

		EntityManagerFactory instance = Persistence.createEntityManagerFactory("fora");

		EntityManager em = instance.createEntityManager();

		//Debut de transaction
		em.getTransaction().begin();

		List<ProductCollection> cheaps = em.createQuery("Select p FROM ProductCollection p where p.price < 2", ProductCollection.class).getResultList();

		System.out.println("#############"+cheaps);

		//28 : id de ma categorie fooding en base
		List<ProductCollection> foodings = em.find(CategoryCollection.class, 28).getProducts();

		System.out.println("#############"+foodings);


		//Fin Transaction
		em.getTransaction().commit();

		em.close();
		instance.close();
	}

}
