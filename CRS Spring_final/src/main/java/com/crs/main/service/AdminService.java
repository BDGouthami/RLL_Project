package com.crs.main.service;

import java.util.List;

import com.crs.main.model.Admin;

public interface  AdminService {
	List <Admin> fetchAllAdmin();
	void saveAdmin(Admin admin);
	Boolean validateAdmin(String adminEmail, String adminPassword);
}
