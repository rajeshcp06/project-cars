package com.Project.carsbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Project.dao.ProductDAO;
import com.Project.model.Product;

public class ProductUnitTest {

	static ProductDAO productDAO;
  	@BeforeClass
  	public static void executeFirst()
  	{
  		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
  		 context.scan("com.project");
  	     context.refresh();
  	     productDAO =(ProductDAO)context.getBean("productDAO");
  	} 
 
  	@Test
  	public void addProductTest() 
	{
		Product product = new Product();
		product.setProductName("NEW figo");
		product.setProductFuel("DIESEL");
		product.setProductDesc("5 SEAT AND FUEL CONSUMING CAR");
		product.setColour("mass red");
		product.setStock(20);
		product.setMilage(20);
		product.setPrice("515000");
		product.setCategoryID(1);
		product.setSupplierID(1);
		assertTrue("Problem in adding Product",productDAO.addProduct(product));
	}
	@Ignore
  	@Test
  	public void deleteProductTest()
  	{
  		Product product = productDAO.getProduct(10);
  		assertTrue("Problem in deleting Product",productDAO.deleteProduct(product));
  	}
  	@Test
  	public void updateProductTest()
  	{
  		Product product = productDAO.getProduct(11);
  		product.setStock(10);
  		assertTrue("Problem in updating Product",productDAO.updateProduct(product));
  	}
  	@Test
  	public void listProductsTeest()
	{
		List<Product> listProducts = productDAO.listProducts();
		assertTrue("Problem in Listing Suppliers",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println("Product ID : " +product.getProductID());
			System.out.println("Product Name : " +product.getProductName());
			System.out.println("Product Fuel : " +product.getProductFuel());
			System.out.println("Product Description : " +product.getProductDesc());
			System.out.println("Product colour : " +product.getColour());
			System.out.println("Product Stock : " +product.getStock());
			System.out.println("Product Price : " +product.getPrice());
			System.out.println("Product milage : " +product.getMilage());
			System.out.println("Product's CategoryID : " +product.getCategoryID());
			System.out.println("Product's SupplierID : " +product.getSupplierID());
			
		}



	}
}