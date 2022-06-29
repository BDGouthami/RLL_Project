package com.crs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crs.main.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
