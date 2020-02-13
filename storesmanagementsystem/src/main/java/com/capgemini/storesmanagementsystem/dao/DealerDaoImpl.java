package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;

public class DealerDaoImpl implements DealerDao {
	

	public List<String> loginDealer(String userId, String password) {
		List<String> users = new ArrayList<String>();

		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from userdetailinfo where userId ='" + userId + "' and password='" + password + "'";
		try
				(Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);
				ResultSet rs = pstmt.executeQuery();) {
			Class.forName("com.mysql.jdbc.Driver");

			while (rs.next()) {
				users.add(rs.getString("userId"));
				users.add(rs.getString("password"));

			}
		} catch (Exception e) {
			e.getMessage();
		}

		return users;
	}

	public boolean makeOrder(OrderDetailsInfo order) {
		boolean isAdded = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = " insert into  orderdetailsinfo values (?,?,?,?,?,?,?)";
		try  
		(Connection con = DriverManager.getConnection(dburl);
		PreparedStatement	pstmt = con.prepareStatement(qry);){
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, order.getUserName());
			pstmt.setString(2, order.getPassword());
			pstmt.setInt(3, order.getOrderId());
			pstmt.setInt(4, order.getProductId());
			pstmt.setInt(5, order.getQuantity());
			pstmt.setString(6, order.getAddress());
			pstmt.setInt(7, order.getUserId());

			int r = pstmt.executeUpdate();
			System.out.println(r);
			if (r != 0) {
				isAdded = true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return isAdded;
	}

	public boolean deleteOrder(Integer orderId) {
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "delete from orderdetailsinfo where orderId=?";
		try (Connection con = DriverManager.getConnection(dburl);
		PreparedStatement	pstmt = con.prepareStatement(qry);){
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setInt(1, orderId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.getMessage();
		}
		return true;
	}

	public List<String> showAllproducts() {
		List<String> productlist = new ArrayList<String>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from productdetailsinfo";

		try 
			(Connection con = DriverManager.getConnection(dburl);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);
){
			Class.forName("com.mysql.jdbc.Driver");
			while (rs.next()) {
				productlist.add(rs.getString("productName"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;
	}

	public List<String> viewMyStore(int storesId) {
		List<String> storelist = new ArrayList<String>();
		String qry = "select * from storesinfo where storesId='" + storesId + "'";
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		try (
			Connection con = DriverManager.getConnection(dburl);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);
){
			Class.forName("com.mysql.jdbc.Driver");
			while (rs.next()) {
				storelist.add(rs.getString("numOfItems"));
			}

		} catch (Exception e) {

			e.getMessage();
		}
		return storelist;
	}

	public List<String> viewMyOrders(int userId) {
		List<String> orderlist = new ArrayList<String>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from orderdetailsinfo where userId='" + userId + "'";
		
		try (
				Connection con = DriverManager.getConnection(dburl);
				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(qry);
	){
				Class.forName("com.mysql.jdbc.Driver");
			while (rs.next()) {
				orderlist.add(rs.getString("userName"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return orderlist;
	}



	

}

