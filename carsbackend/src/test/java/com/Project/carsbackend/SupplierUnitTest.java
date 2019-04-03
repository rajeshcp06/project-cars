package com.Project.carsbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Project.dao.SupplierDAO;

import com.Project.model.Supplier;

public class SupplierUnitTest {

	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		 context.scan("com.project");
	     context.refresh();
	     supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	@Test
		public void addSupplierTest() 
		{
			
				Supplier supplier = new Supplier();
				supplier.setSupplierName("palani");
				supplier.setSupplierMobileNo("8015846131");
				supplier.setSupplierMailId("palanicg@gmail.com");
				supplier.setSupplierAddr("india");
			    assertTrue("Problem in adding Supplier",supplierDAO.addSupplier(supplier));
		}	
	    @Ignore
		@Test
		public void deleteCategoryTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(7);
	    	assertTrue("Problem in deleting Supplier",supplierDAO.deleteSupplier(supplier));
	    }
	    @Ignore
		@Test
		public void listSuppliersTeest()
		{
			List<Supplier> listSuppliers = supplierDAO.listSuppliers();
			assertTrue("Problem in Listing Suppliers",listSuppliers.size()>0);
			for(Supplier supplier:listSuppliers)
			{
				System.out.println("Supplier ID : " +supplier.getSupplierId());
				System.out.println("Supplier Name : " +supplier.getSupplierName());
				System.out.println("Supplier Name : " +supplier.getSupplierMobileNo());
				System.out.println("Supplier Name : " +supplier.getSupplierMailId());
				System.out.println("Supplier Description : " +supplier.getSupplierAddr());
			}
		}
		@Ignore
	    @Test
	    public void updateSupplierTest()
	    {
	    	Supplier supplier = supplierDAO.getSupplier(6);
	    	supplier.setSupplierAddr("INDIA");
	    	assertTrue("Problem in Updating Suppliers",supplierDAO.updatesupplier(supplier));
	    }

}
