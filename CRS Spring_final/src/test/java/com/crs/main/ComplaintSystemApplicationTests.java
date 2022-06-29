package com.crs.main;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crs.main.model.Complaints;
import com.crs.main.model.Customers;
import com.crs.main.model.Engineers;
import com.crs.main.repository.ComplaintRepository;
import com.crs.main.repository.CustomerRepository;
import com.crs.main.repository.EngineerRepository;
import com.crs.main.service.CustomerService;
import com.crs.main.service.CustomerServiceImpl;
import com.crs.main.service.EngineerSerivceImpl;
import com.crs.main.service.EngineerService;

@SpringBootTest(classes = ComplaintSystemApplication.class)
class ComplaintSystemApplicationTests
{
	@Autowired
	private CustomerRepository cusRepo;
	
	@Autowired
	private EngineerRepository engRepo;
	
	@Autowired
	private ComplaintRepository complainRepo;
	@Test
//	@Disabled
	
	public void testCreate()
	{
		Customers c=new Customers();
		c.setCustomerAddress("sircilla");
		c.setCustomerEmail("ramani999@gmail.com");
		c.setCustomerMobile("8978675687");
		c.setCustomerName("ramani");
		c.setCustomerPassword("1234");
		c.setCustomerPincode("1234554");
		cusRepo.save(c);
		
		
		
	}
	
	@Test
	public void testEnginners()
	{
		Engineers e=new Engineers();
		e.setEngineerEmail("ramani999@gmail.com");
		e.setEngineerName("ramani");
		e.setEngineerPassword("1234");
		engRepo.save(e);
	}
	
	@Test
	public void testComplaints()
	{
		Complaints com1=new Complaints();
		com1.setCustomerEmail("ramani999@gmail.com");
		com1.setComplaint("not getting good wifi here in sircilla");
		com1.setStatus("rejected");
		com1.setPincode("6785494");
		complainRepo.save(com1);
	}
	
	
	

	
	

}
