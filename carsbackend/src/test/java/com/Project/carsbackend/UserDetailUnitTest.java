package com.Project.carsbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Project.dao.UserDetailDAO;
import com.Project.model.UserDetail;

public class UserDetailUnitTest {

	static UserDetailDAO userdetailDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		 context.scan("com.project");
	     context.refresh();
	     userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}    
	  
	@Test
	public void addusertest() 
	{
		UserDetail user = new UserDetail();
		user.setCustomername("rajesh");
		user.setCustomerAddr("CHENNAI");
		user.setUsername("rajesh");
		user.setPassword("RAJ@12");
		user.setRole("ADMIN");
		user.setCustomerMobileNo("8248258098");
		user.setCustomerMailId("rajeshcp06@gmail.com");
		user.setEnabled(true);
		assertTrue("Problem in adding User Details",userdetailDAO.registerUser(user));
	}
    @Ignore
    @Test
    public void updateusertest()
    {
    	UserDetail user = userdetailDAO.getUser("vicky");
    	user.setCustomerAddr("Delhi Kingsway");
		assertTrue("Problem in updating User Details",userdetailDAO.updateAddress(user));
	}
  @Ignore
    @Test
    public void viewusertest()
    {
    	UserDetail user = userdetailDAO.getUser("Logesh");

    	System.out.println("Customer name           :"+user.getCustomername());
    	System.out.println("Customer Address        :"+user.getCustomerAddr());
		System.out.println("Customer MobileNo 		:"+user.getCustomerMobileNo());
		System.out.println("Customer MailId 		:"+user.getCustomerMailId());
    	System.out.println("Customer Account Status :"+user.isEnabled());
       
    }

}
