package com.srini.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srini.shopingbackend.dao.CategoryDAO;
import com.srini.shopingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.srini.shopingbackend");
		context.refresh();
		
	categoryDAO = (CategoryDAO)context.getBean("categoryDAO");	
	}
	
	 /*@Test
	public  void testAddCategory()
	{
		category = new Category();
		category.setName("laptop");
		category.setDescription("this is some description");
		category.setImageURL("cat_1.png");
		
		assertEquals("successfully added elements inside the table",true,categoryDAO.add(category));
	}
	*/
	
	/*@Test
	
	public void testGetCategory() 
	{
		category = categoryDAO.get(2);
		assertEquals("successfully fetched a single category element from the table","laptop",category.getName());
		
	}*/
	
/*@Test
	
	public void testUpdateCategory() 
	{
		category = categoryDAO.get(2);
		category.setName("lap");
		assertEquals("successfully updated a single category element from the table",true,categoryDAO.update(category));
		
	}*/
	
/*@Test
	
	public void testDeleteCategory() 
	{
		category = categoryDAO.get(2);
		assertEquals("successfully deleted a single category element from the table",true,categoryDAO.delete(category));
		
	}
	*/
	
/*@Test
	
	public void testListCategory() 
	{
		
		assertEquals("successfully fetched the list of  category element from the table",1,categoryDAO.list().size());
		
	}
	

	*/
	
	@Test
	public void testCRUDCategory()
	{
		// add operation
		category = new Category();
		category.setName("laptop");
		category.setDescription("this is some description of laptop");
		category.setImageURL("cat_1.png");
		
		assertEquals("successfully added elements inside the table",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("television");
		category.setDescription("this is some description of television");
		category.setImageURL("cat_2.png");
		
		assertEquals("successfully added elements inside the table",true,categoryDAO.add(category));
		
		// updating operation
		category = categoryDAO.get(2);
		category.setName("tv");
		assertEquals("successfully updated a single category element from the table",true,categoryDAO.update(category));
		
		
		//deleting operation
		
		
		assertEquals("successfully deleted a single category element from the table",true,categoryDAO.delete(category));
		
		
		//testing operation
		assertEquals("successfully fetched the list of  category element from the table",1,categoryDAO.list().size());
		
		
		
		
	
	
	}
}
	
	