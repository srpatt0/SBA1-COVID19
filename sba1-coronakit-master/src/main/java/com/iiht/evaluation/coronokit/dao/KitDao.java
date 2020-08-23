package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.model.UserMaster;



public class KitDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public KitDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	// add DAO methods as per requirements
		public ProductMaster getProductData(String productId) throws ClassNotFoundException, SQLException {
			String sql = "select * from userinfo where product_id = " + productId;
			this.connect();
			Statement stmt = this.jdbcConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// map it to model

			rs.next();
			ProductMaster product = new ProductMaster();
			//ProductMaster product = new ProductMaster(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
			rs.close();
			stmt.close();
			this.disconnect();

			return product;
		}
		
		

	// add DAO methods as per requirements
		public boolean addNewUser(UserMaster user) throws ClassNotFoundException, SQLException {
			String sql = "INSERT INTO user (personName, email, contactNumber,deliveryAddress) VALUES(?,?,?,?)";
			
			this.connect();
			PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
			pstmt.setString(1, user.getPersonName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getContactNumber());
			pstmt.setString(4, user.getDeliveryAddress());			

			boolean added = pstmt.executeUpdate() > 0;

			pstmt.close();
			this.disconnect();
			return added;
		}

}