package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.model.ProductMaster;

public class ProductMasterDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ProductMasterDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public List<ProductMaster> getProductRecords() throws ClassNotFoundException, SQLException {
		String sql = "select * from product";
		this.connect();
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		// map it to model
		List<ProductMaster> products = new ArrayList<ProductMaster>();
		while (rs.next()) {
			ProductMaster product = new ProductMaster(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
			products.add(product);
		}

		rs.close();
		stmt.close();
		this.disconnect();

		return products;
	}

	// add DAO methods as per requirements
	public ProductMaster getProductData(String productId) throws ClassNotFoundException, SQLException {
		String sql = "select * from product where product_id = " + productId;
		this.connect();
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		// map it to model

		rs.next();
		ProductMaster product = new ProductMaster(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
		rs.close();
		stmt.close();
		this.disconnect();

		return product;
	}

	// This method is add new product

	public boolean addNewProduct(ProductMaster product) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO product (product_name, product_cost, product_desc) VALUES(?,?,?)";
		
		this.connect();
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, product.getProductName());
		pstmt.setDouble(2, product.getCost());
		pstmt.setString(3, product.getProductDescription());

		boolean added = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return added;
	}

	public int updateProduct(ProductMaster product) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET product_name = ?, product_desc = ?, product_cost = ? WHERE product_id = ?";
		this.connect();
		PreparedStatement pstmt = jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, product.getProductName());
		pstmt.setString(2, product.getProductDescription());
		pstmt.setDouble(3, product.getCost());
		pstmt.setInt(4, product.getId());
		int rows = pstmt.executeUpdate();
		pstmt.close();
		this.disconnect();
		return rows;
	}

	// Update Productname for a Record

	public boolean updateProductName(String id, String pname) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET id = ? WHERE pname = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pname);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}

	// Update Productcost for a Record

	public boolean updateProductcost(String id, String pcost) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET id = ? WHERE pcost = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pcost);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}

	// Update Productdesc for a Record

	public boolean updateProductDesc(String id, String pdesc) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET id = ? WHERE pdesc = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pdesc);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}

	// Update All Productname and Product cost details for a Record

	public boolean updatePnamePcost(String id, String pname, String pcost) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET pname = ?,pcost=? WHERE id = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pname);
		pstmt.setString(3, pcost);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}
	// Update All Productname and Prodcut Desc details for a Record

	public boolean updatePnamePdesc(String id, String pname, String pdesc) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET pname = ?,pdesc=? WHERE id = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pname);
		pstmt.setString(3, pdesc);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}
	// Update All Productcost and Prodcut desc details for a Record

	public boolean updatePcostPdesc(String id, String pcost, String pdesc) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET pcost = ?,pdesc=? WHERE id = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pcost);
		pstmt.setString(3, pdesc);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}
	// Update All Product details for a Record

	public boolean updatePnamePcostPdesc(String id, String pname, String pcost, String pdesc)
			throws ClassNotFoundException, SQLException {
		String sql = "UPDATE product SET pname = ?,pcost=?,pdesc=? WHERE id = ?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pname);
		pstmt.setString(3, pcost);
		pstmt.setString(4, pdesc);

		boolean updated = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return updated;
	}

	// Delete Product Record

	public boolean deleteProduct(String id) throws ClassNotFoundException, SQLException {

		String sql = "delete from product where product_id=?";
		this.connect();

		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));

		boolean deleted = pstmt.executeUpdate() > 0;

		pstmt.close();
		this.disconnect();
		return deleted;
	}

}