package io.robusta.jpa.demo.data;

import java.util.ArrayList;
import java.util.List;

import io.robusta.jpa.demo.entities.Category;
import io.robusta.jpa.demo.entities.CategoryCollection;
import io.robusta.jpa.demo.entities.Product;
import io.robusta.jpa.demo.entities.ProductCollection;

public class StaticData {
	
	public static List<Product> productList = new ArrayList<>();
	
	public static List<Category> categoryList = new ArrayList<>();
	
	public static List<ProductCollection> productCList = new ArrayList<>();
	
	public static List<CategoryCollection> categoryCList = new ArrayList<>();
	
	

	//Category standard
	public static List<Product> getProductList() {
		if(productList.size() == 0) {
			productList.add(ketchup);
			productList.add(watch);
			productList.add(milk);
			productList.add(cornflakes);
			productList.add(jeans);
			productList.add(shoes);
			productList.add(chair);
			productList.add(hat);
		}
		return productList;
	}
	
	public static void setProductList(List<Product> productList) {
		StaticData.productList = productList;
	}
	
	
	
	public static List<Category> getCategoryList() {
		if(categoryList.size() == 0) {
			categoryList.add(csp);
			categoryList.add(luxe);
			categoryList.add(premium);
			categoryList.add(standard);
			categoryList.add(lowcost);
			categoryList.add(fooding);
		}
		return categoryList;
	}

	public static void setCategoryList(List<Category> categoryList) {
		StaticData.categoryList = categoryList;
	}

	public static List<ProductCollection> getProductCList() {
		if(productCList.size() == 0) {
			productCList.add(ketchupC);
			productCList.add(watchC);
			productCList.add(milkC);
			productCList.add(cornflakesC);
			productCList.add(jeansC);
			productCList.add(shoesC);
			productCList.add(chairC);
			productCList.add(hatC);
		}
		return productCList;
	}

	public static void setProductCList(List<ProductCollection> productCList) {
		StaticData.productCList = productCList;
	}





	public static List<CategoryCollection> getCategoryCList() {
		if(categoryCList.size() == 0) {
			categoryCList.add(cspC);
			categoryCList.add(luxeC);
			categoryCList.add(premiumC);
			categoryCList.add(standardC);
			categoryCList.add(lowcostC);
			categoryCList.add(foodingC);
		}
		return categoryCList;
	}

	public static void setCategoryCList(List<CategoryCollection> categoryCList) {
		StaticData.categoryCList = categoryCList;
	}





	public static Product ketchup = new Product("Ketchup", 2.35f);
	public static Product watch = new Product("Watch", 19990f);
	public static Product milk = new Product("Milk", 1.15f);
	public static Product cornflakes = new Product("Corn Flakes", 1.55f);
	public static Product jeans = new Product("Jeans", 20.90f);
	public static Product shoes = new Product("Shoes", 15.00f);
	public static Product chair = new Product("Chair", 10.00f);
	public static Product hat = new Product("Hat", 70f);

	public static Category csp = new Category("CSP");
	public static Category luxe = new Category("luxory");
	public static Category premium = new Category("premium");
	public static Category standard = new Category("standard");
	public static Category lowcost = new Category("low-cost");
	public static Category fooding = new Category("fooding");

	//par collection category -> produits
	public static ProductCollection ketchupC = new ProductCollection(ketchup);
	public static ProductCollection watchC = new ProductCollection(watch);
	public static ProductCollection milkC = new ProductCollection(milk);
	public static ProductCollection cornflakesC = new ProductCollection(cornflakes);
	public static ProductCollection jeansC = new ProductCollection(jeans);
	public static ProductCollection shoesC = new ProductCollection(shoes);
	public static ProductCollection chairC = new ProductCollection(chair);
	public static ProductCollection hatC = new ProductCollection(hat);

	public static CategoryCollection cspC = new CategoryCollection(csp);
	public static CategoryCollection luxeC = new CategoryCollection(luxe);
	public static CategoryCollection foodingC = new CategoryCollection(fooding);
	public static CategoryCollection premiumC = new CategoryCollection(premium);
	public static CategoryCollection standardC = new CategoryCollection(standard);
	public static CategoryCollection lowcostC = new CategoryCollection(lowcost);

}
