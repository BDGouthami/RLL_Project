package com.crs.main.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crs.main.model.Admin;
import com.crs.main.model.Customers;
import com.crs.main.model.EngineerDuty;
import com.crs.main.repository.AdminRepository;
import com.crs.main.service.AdminService;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping(path="/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	AdminRepository adminrepository;
	
	
	@PostMapping("/login")
	public Boolean validateAdmin(@RequestBody Object loginDetails) throws NoSuchFieldException {
		
			String adminEmail = (String) ((LinkedHashMap) loginDetails).get("adminEmail");
			String adminPassword = (String) ((LinkedHashMap) loginDetails).get("adminPassword");
			
			Boolean adminLoginStatus = adminService.validateAdmin(adminEmail,adminPassword );
		
			return adminLoginStatus;
			
	} 
	
	
	@PostMapping(path = "/addAdmin")
	public @ResponseBody void addAdmin(@RequestBody Admin admin) {
		adminService.saveAdmin(admin);
		
	}

}
