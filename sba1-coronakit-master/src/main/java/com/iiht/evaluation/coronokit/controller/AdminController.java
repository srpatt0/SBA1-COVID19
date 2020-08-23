package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.ProductMaster;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterDao productMasterDao;

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {

		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");

		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String viewName = "";
		try {
			switch (action) {
			case "login":
				viewName = adminLogin(request, response);
				break;
			case "newproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response);
				break;
			case "editproduct":
				viewName = showEditProductForm(request, response);
				break;
			case "updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "list":
				viewName = listAllProducts(request, response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);

	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		return "index.jsp";
	}

	private String listAllProducts(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		List<ProductMaster> products = this.productMasterDao.getProductRecords();
		request.setAttribute("Products", products);
		return "listproducts.jsp";
	}

	private String updateProduct(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException {
		// TODO Auto-generated method stub
		ProductMaster product = new ProductMaster(Integer.parseInt(request.getParameter("pId")),
				request.getParameter("pname"), Double.parseDouble(request.getParameter("pcost")),
				request.getParameter("pdesc"));
		
		if(request.getParameter("pname").length() == 0 || request.getParameter("pcost").length() == 0 || request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0 && request.getParameter("pcost").length() == 0 && request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0 && request.getParameter("pcost").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0 && request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pcost").length() == 0 && request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pcost").length() == 0 )
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0)
		{
			return "productmiss.jsp";
		}
		else {
		int result = this.productMasterDao.updateProduct(product);
		if (!(result>0)) {
			throw new ServletException("Product is not added successfully. Please try again");
		}
		return "admin?action=list";
	}
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ProductId");
		ProductMaster product = this.productMasterDao.getProductData(id);
		request.setAttribute("product", product);
		return "editproduct.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ProductId");
		this.productMasterDao.deleteProduct(id);
		return "admin?action=list";

	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException {

		ProductMaster product = new ProductMaster(request.getParameter("pname"),
				Double.parseDouble(request.getParameter("pcost")), request.getParameter("pdesc"));
		
		if(request.getParameter("pname").length() == 0 || request.getParameter("pcost").length() == 0 || request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0 && request.getParameter("pcost").length() == 0 && request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0 && request.getParameter("pcost").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0 && request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pcost").length() == 0 && request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pcost").length() == 0 )
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pdesc").length() == 0)
		{
			return "productmiss.jsp";
		}
		else if(request.getParameter("pname").length() == 0)
		{
			return "productmiss.jsp";
		}
		else {

		boolean insertresult = this.productMasterDao.addNewProduct(product);

		if (!insertresult) {
								
		throw new ServletException("Product is not added successfully. Please try again");
		}

		return "admin?action=list";
	}
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "newproduct.jsp";
	}

	private String adminLogin(HttpServletRequest request, HttpServletResponse response) {

		String uname = request.getParameter("loginid");
		String pswd = request.getParameter("password");

		if (uname.equalsIgnoreCase("admin") && pswd.equalsIgnoreCase("admin")) {

			return "admin?action=list";

		}

		return "invalidlogin.jsp";
	}

}