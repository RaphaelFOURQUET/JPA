package io.robusta.jpa.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.data.StaticData;
import io.robusta.jpa.demo.entities.Caddie;
import io.robusta.jpa.demo.entities.Product;

public class FetchCaddieApplication {

	public static void main(String[] args) {//

		EntityManagerFactory instance = Persistence.createEntityManagerFactory(StaticData.ENTITYMANAGER_FACTORY_NAME);

		EntityManager em = instance.createEntityManager();

		//Debut de transaction
		em.getTransaction().begin();

		
		String categoryName = em.find(Product.class, 9).getCategory().getName();
		System.out.println("################"+categoryName);
		
		Caddie caddie = em.find(Caddie.class, 15);
		
		System.out.println("############ caddie : "+caddie);
		for(Product p : caddie.getProducts()) {
			System.out.println("############ myCaddie : "+p.getName()+" - "+p.getPrice());
		}

		//Fin Transaction
		em.getTransaction().commit();

		em.close();
		instance.close();

	}

}
