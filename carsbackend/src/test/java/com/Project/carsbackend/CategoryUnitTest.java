package com.Project.carsbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.Project.dao.CategoryDAO;
import com.Project.model.Category;

public class CategoryUnitTest {

	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	     context.scan("com.Project");
	     context.refresh();
	     categoryDAO=(CategoryDAO)context.getBean("categoryDao");
	     
	}

	@Test
	public void addCategoryTest() 
	{
		Category category = new Category();
		category.setCategoryName("FORD");
		category.setCategoryDesc("US company");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
		System.out.println("Category Added");
	}
	@Ignore
    @Test
    public void deleteCategoryTest()
    {
    	Category category=categoryDAO.getcategory(1);
    	assertTrue("Problem in deleting Category",categoryDAO.deleteCategory(category));
    }
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories = categoryDAO.listCategories();
		assertTrue("Problem in Listing Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println("Category ID : " +category.getCategoryID());
			System.out.println("Category Name : " +category.getCategoryName());
			System.out.println("Category Description : " +category.getCategoryDesc());
		}
		
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getcategory(2);
		category.setCategoryName("");
		category.setCategoryDesc("");
    	assertTrue("Problem in updating Category",categoryDAO.updateCategory(category));

	}

}
