package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class ManufacturerDaoImpl implements ManufacturerDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public boolean addDealer(UserDetailsInfo dealer) {
		boolean isAdded = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger";
		String qry = " insert into  userdetailinfo  values (?,?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, dealer.getUserId());
			pstmt.setString(2, dealer.getUserName());
			pstmt.setString(3, dealer.getEmail());
			pstmt.setString(4, dealer.getPassword());
			pstmt.setString(5, dealer.getAddress());
			pstmt.setString(6, dealer.getUserRole());
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

	public boolean modifyDealer(String userId, UserDetailsInfo user) {
		boolean isModified = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger";
		String qry = "update userdetailinfo set userName=?,address=?,password=? where userId='" + userId + "' ";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			int n = pstmt.executeUpdate();
			if (n != 0)
				isModified = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isModified;
	}

	public boolean removeDealer(String dealerId) {
		boolean isRemoved = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "delete from userdetailinfo where userId=?";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, dealerId);
			int n = pstmt.executeUpdate();

			if (n != 0)
				isRemoved = true;

		} catch (Exception e) {

			e.getMessage();
		}
		return isRemoved;
	}

	public List<String> viewAllDealers(String role) {
		List<String> manufactures = new ArrayList<>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from userdetailinfo where userRole='" + role + "' ";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);

				ResultSet rs = pstmt.executeQuery(qry);) {
			Class.forName("com.mysql.jdbc.Driver");

			while (rs.next()) {
				manufactures.add(rs.getString("userName"));

			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}

	public boolean addProduct(ProductDetailsInfo product) {
		boolean isAdded = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = " insert into  productdetailsinfo  values (?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setInt(1, product.getProduct());
			pstmt.setString(2, product.getProductName());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setInt(4, product.getStocks());
			pstmt.setString(5, product.getWarranty());

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

	public boolean modifyProduct(int productId, ProductDetailsInfo product) {
		boolean isUpdate = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "update productdetailsinfo set price=?,warranty=? where productId='" + productId + "' ";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setDouble(1, product.getPrice());
			pstmt.setString(2, product.getWarranty());

			int n = pstmt.executeUpdate();
			if (n != 0)
				isUpdate = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isUpdate;
	}

	public boolean removeProduct(Integer productId) {
		boolean isDeleted = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "delete from productdetailsinfo where productId=?";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setInt(1, productId);
			int n = pstmt.executeUpdate();
			if (n != 0)
				isDeleted = true;
		} catch (Exception e) {

			e.getMessage();
		}
		return isDeleted;

	}

	public List<String> viewAllProducts() {
		List<String> productlist = new ArrayList<>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from productdetailsinfo";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);

				ResultSet rs = pstmt.executeQuery(qry);) {
			Class.forName("com.mysql.jdbc.Driver");

			while (rs.next()) {
				productlist.add(rs.getString("productName"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewAllOrders() {
		List<String> productlist = new ArrayList<>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from orderdetailsinfo";

		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);

				ResultSet rs = pstmt.executeQuery(qry);) {
			Class.forName("com.mysql.jdbc.Driver");

			while (rs.next()) {
				productlist.add(rs.getString("userId"));
				productlist.add(rs.getString("userName"));
				productlist.add(rs.getString("address"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewStore() {

		List<String> productlist = new ArrayList<>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from storesinfo";

		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);

				ResultSet rs = pstmt.executeQuery(qry);) {
			Class.forName("com.mysql.jdbc.Driver");

			while (rs.next()) {
				productlist.add(rs.getString("storesId"));
				productlist.add(rs.getString("numOfItems"));
				productlist.add(rs.getString("minStocksPresent"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

}
