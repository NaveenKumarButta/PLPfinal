package com.capgemini.storesmanagementsystem.dao;

import java.util.List;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public interface AdminDao {
	public List<String> loginAdmin(String userId, String password);

	public boolean addManufactur(UserDetailsInfo user);
	public boolean updateManufactur(String userId,UserDetailsInfo user);
	public boolean deleteManufactur(String userId);
	public List<String> viewAllManufacturs();
}
