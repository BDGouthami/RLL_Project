package com.crs.main.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.main.model.Admin;
import com.crs.main.model.Customers;
import com.crs.main.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	
	public List<Admin> fetchAllAdmin() {
		return adminRepository.findAll();
	}
	
	public void saveAdmin(Admin admin) {
		if(admin.getAdminName().equals("admin")&& admin.getAdminPassword().equals("admin"))
		{
			adminRepository.save(admin);
		}else {
		
		throw new RuntimeException("please provide valid username and password");}
	}
	
	public Boolean validateAdmin(String adminEmail, String adminPassword) {
		System.out.println(adminEmail + " --- "+adminEmail);
		if (adminRepository.findById(adminEmail).isPresent()) {
			Admin admin= adminRepository.findById(adminEmail).get();
			String dbPassword = admin.getAdminPassword().toString();
			if (dbPassword.equals(adminPassword)) {
				return true;
			}
		}
		return false;
	}
}
