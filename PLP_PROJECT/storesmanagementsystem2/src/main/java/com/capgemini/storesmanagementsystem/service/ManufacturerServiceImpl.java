package com.capgemini.storesmanagementsystem.service;

import java.util.List;

import com.capgemini.storesmanagementsystem.dao.ManufacturerDao;
import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class ManufacturerServiceImpl implements ManufacturerService{
	private ManufacturerDao dao;

	public List<String> loginManufacturer(Integer userId, String password) {
	return dao.loginManufacturer(userId, password);
	}

	@Override
	public boolean addDealer(UserDetailsInfo dealer) {
		return dao.addDealer(dealer);
	}

	@Override
	public boolean modifyDealer(String user) {
		return dao.modifyDealer(user);
	}

	@Override
	public boolean removeDealer(String dealerId) {
		return dao.removeDealer(dealerId);
	}

	@Override
	public List<String> viewAllDealers(String role) {
		return dao.viewAllDealers(role);
	}

	@Override
	public boolean addProduct(ProductDetailsInfo product) {
		return dao.addProduct(product);
	}

	@Override
	public boolean modifyProduct(String product) {
		return dao.modifyProduct(product);
	}

	@Override
	public boolean removeProduct(Integer productId) {
		return dao.removeProduct(productId);
	}

	@Override
	public List<String> viewAllProducts() {
		return dao.viewAllProducts();
	}

	@Override
	public List<String> viewAllOrders() {
		return dao.viewAllOrders();
	}

	@Override
	public List<String> viewStore() {
		return dao.viewStore();
	}
}
