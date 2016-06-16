package io.robusta.jpa.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.data.StaticData;
import io.robusta.jpa.demo.entities.ProductCollection;

public class FetchApplication {

	public static void main(String[] args) {

		EntityManagerFactory instance = Persistence.createEntityManagerFactory(StaticData.ENTITYMANAGER_FACTORY_NAME);

		EntityManager em = instance.createEntityManager();

		//Debut de transaction
		em.getTransaction().begin();

		List<ProductCollection> cheaps = em.createQuery("Select p FROM ProductCollection p where p.price < 2", ProductCollection.class).getResultList();

		System.out.println("#############"+cheaps);

//		//28 : id en dur de ma categorie fooding en base : moche
//		List<ProductCollection> foodings = em.find(CategoryCollection.class, 28).getProducts();
//		
//		System.out.println("#############"+foodings);
		
		List<ProductCollection> foodings = em
				.createQuery("Select p From CategoryCollection c Join c.products p Where c.id=:id Order By p.price", ProductCollection.class)
				.setParameter("id", 28).getResultList();
		
		System.out.println("#############"+foodings);


		//Fin Transaction
		em.getTransaction().commit();

		em.close();
		instance.close();
	}

}
