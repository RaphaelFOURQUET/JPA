package io.robusta.jpa.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.robusta.jpa.demo.data.StaticData;
import io.robusta.jpa.demo.entities.Caddie;
import io.robusta.jpa.demo.entities.Category;
import io.robusta.jpa.demo.entities.Product;

public class CaddieApplication {

	public static void main(String[] args) {


		EntityManagerFactory instance = Persistence.createEntityManagerFactory(StaticData.ENTITYMANAGER_FACTORY_NAME);

		EntityManager em = instance.createEntityManager();

		//Debut de transaction
		em.getTransaction().begin();

		Caddie caddie = new Caddie();

		for(Category c : StaticData.categoryList)
			em.persist(c);

		for(Product p : StaticData.productList)
			em.persist(p);

		StaticData.ketchup.setCategory(StaticData.fooding);
		StaticData.milk.setCategory(StaticData.fooding);
		StaticData.cornflakes.setCategory(StaticData.fooding);

		caddie.addProduct(StaticData.ketchup);
		caddie.addProduct(StaticData.milk);
		caddie.addProduct(StaticData.cornflakes);

		em.persist(caddie);

		//Fin Transaction
		em.getTransaction().commit();

		em.close();
		instance.close();


	}

}
