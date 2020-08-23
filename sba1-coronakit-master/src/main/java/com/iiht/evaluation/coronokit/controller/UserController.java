package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.coronokit.dao.KitDao;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.AddressMaster;
import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.model.UserMaster;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitDao kitDAO;
	private ProductMasterDao productMasterDao;
	private HttpSession session;

	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config. getServletContext().getInitParameter("jdbcPassword");
		
		this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "insertuser":
				viewName = insertNewUser(request, response);
				break;
			case "showproducts":
				viewName = showAllProducts(request, response);
				break;	
			case "addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;	
			case "ordersummary":
				viewName = showOrderSummary(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	
	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "ordersummary.jsp";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		List<KitDetail> cart = (List<KitDetail>) session.getAttribute("CartData");
		UserMaster user = (UserMaster) session.getAttribute("UserMaster");
		user.setDeliveryAddress(request.getParameter("deliveryAddress"));
		
		return "ordersummary.jsp";
	}

	
	
	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("ProductId");
		ProductMaster product = this.productMasterDao.getProductData(id);
		request.setAttribute("product", product);
		return "showkit.jsp";		
		
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("ProductId"));
		List<KitDetail> cart = (List<KitDetail>) session.getAttribute("CartData");
		int index = isExistingKitProduct(id, cart);
		cart.remove(index);
		session.setAttribute("CartData", cart);
		if(cart.size()==0)
		{
			session.removeAttribute("CartData");
			return "user?action=showproducts";
		}
		return "user?action=showkit";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		session = request.getSession();
		KitDetail kit;
		
		String id = request.getParameter("ProductId");
		ProductMaster product = this.productMasterDao.getProductData(id);
		if (session.getAttribute("CartData") == null) {
			Random r = new Random();
			int ckitId = (int) (1+(r.nextDouble() *(Integer.MAX_VALUE-1)));
			List<KitDetail> cart = new ArrayList<KitDetail>();
			kit = new KitDetail(1, ckitId, product.getId(), product.getProductName(), 1, product.getCost());
			cart.add(kit);
			session.setAttribute("CartData", cart);
			session.setAttribute("CoronaKitId", kit.getCoronaKitId());
		}else {
			List<KitDetail> cart = (List<KitDetail>) session.getAttribute("CartData");
			int index = isExistingKitProduct(product.getId(), cart);
			if (index == -1) {
				kit = new KitDetail(cart.get(cart.size() - 1).getId() + 1, (int) session.getAttribute("CoronaKitId"), product.getId(), product.getProductName(), 1, product.getCost());
				cart.add(kit);
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
				cart.get(index).setAmount(quantity * product.getCost());
			}
			session.setAttribute("CartData", cart);
		}

		return "user?action=showkit";
	}
	
	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		String deliveryAddress = request.getParameter("deliveryAddress");
		session =request.getSession();
		session.setAttribute("Address", deliveryAddress);
		return "placeorder.jsp";
	}																										

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		List<ProductMaster> products = this.productMasterDao.getProductRecords();
		request.setAttribute("Products", products);			
		return "showproductstoadd.jsp";
	}

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException {
		// TODO Auto-generated method stub
		
		UserMaster user = new UserMaster(request.getParameter("uname"), request.getParameter("uemail"),
				request.getParameter("ucontact"), request.getParameter("uaddress"));
		
		session =request.getSession();
		session.setAttribute("UserDetails", user);
		//boolean insertresult = this.kitDAO.addNewUser(user);

//		if (!insertresult) {
//			throw new ServletException("User is not added successfully. Please try again");
//		}

		return "user?action=showproducts";
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "newuser.jsp";
	}
	
	private int isExistingKitProduct(int productId, List<KitDetail> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProductId() == productId) {
				return i;
			}
		}
		return -1;
	}
}