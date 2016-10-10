package com.tcs.ilp.tsis.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.tsis.dao.InventoryDao;
import com.tcs.ilp.tsis.model.DefectProductOrder;
import com.tcs.ilp.tsis.model.ProductModelInfoTable;
import com.tcs.ilp.tsis.model.ProductStockTable;
import com.tcs.ilp.tsis.model.Retailer;
import com.tcs.ilp.tsis.model.Search;


public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InventoryDao inventoryDao = new InventoryDao();
	ServletContext ctx = null;

	private RequestDispatcher rd = null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			try {
				handleRequest(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			try {
				handleRequest(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NamingException, SQLException
	{
		
		response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		
		
	    ctx = getServletContext();
	    	    
		HttpSession session = request.getSession(false);
		
		if(session==null || session.getAttribute("username")==null)
		{
			response.sendRedirect("/Project/JspPages/login.jsp");
			return;
		}
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("addModelPage"))
		{
			rd = ctx.getRequestDispatcher("/JspPages/AddModel.jsp");
			rd.forward(request,response);
		}
		else if(action.equalsIgnoreCase("addModel"))
		{
			addModel(request, response);
		}
		else if(action.equalsIgnoreCase("updateModelList"))
		{
			updateModelList(request, response);
		}
		else if(action.equalsIgnoreCase("updateModel"))
		{
			updateModel(request,response);
		}
		else if(action.equalsIgnoreCase("updateModelInfo"))
		{
			updateModelInfo(request,response);
		}
		else if(action.equalsIgnoreCase("viewModel"))
		{
			viewModel(request,response);
		}
		else if(action.equalsIgnoreCase("deleteModel"))
		{
			deleteModel(request, response);
		}
		else if(action.equalsIgnoreCase("deleteModelInfo"))
		{
			deleteModelInfo(request, response);
		}
		else if(action.equalsIgnoreCase("tagModel"))
		{
			tagModel(request, response);
		}
		else if(action.equalsIgnoreCase("taggedModels"))
		{
			taggedModels(request, response);
		}
		else if(action.equalsIgnoreCase("tag"))
		{
			tag(request,response);
		}
		else if(action.equalsIgnoreCase("viewStock"))
		{
			viewStock(request, response);
		}
		else if(action.equalsIgnoreCase("viewProducts"))
		{
			viewProducts(request, response);
		}
		else if(action.equalsIgnoreCase("addProductModel"))
		{
			addProductModel(request, response);
		}
		else if(action.equalsIgnoreCase("addProduct"))
		{
			addProduct(request, response);
		}
		/*else if(action.equalsIgnoreCase("delProduct"))
		{
			deleteProduct(request, response);
		}*/
		
		/*else if(action.equalsIgnoreCase("delProductInfo"))
		{
			deleteProductInfo(request, response);
		}*/
		else if(action.equalsIgnoreCase("deleteProducts"))
		{
			deleteProductsCheck(request, response);
		}
		else if(action.equalsIgnoreCase("deleteProductscheckBox"))
		{
			deleteProductsCheckBox(request, response);
		}
		else if(action.equalsIgnoreCase("updateStatus"))
		{
			dispatchProducts(request, response);
		}
		else if(action.equalsIgnoreCase("ReplaceProduct"))
		{
			replaceProd(request, response);
		}
		else if(action.equalsIgnoreCase("ReplaceProductCode"))
		{
			replaceProdInfo(request, response);
		}
		else if(action.equalsIgnoreCase("Search"))
		{
			search(request, response);
		}
		else if(action.equalsIgnoreCase("SearchType"))
		{
			searchType(request, response);
		}
		else if(action!=null && action.equals("logout"))
		{
			session.invalidate();
			response.sendRedirect("/Project/JspPages/login.jsp");
			return;
			
		}
	}
	
	private void addModel(HttpServletRequest request, HttpServletResponse response)
	{
		ProductModelInfoTable pmit = new ProductModelInfoTable();
		pmit.setProdModelId(request.getParameter("prodModelId"));
		pmit.setProdModelName(request.getParameter("prodModelName"));
		pmit.setProdModelDesc(request.getParameter("prodModelDesc"));
		pmit.setProdModelFeatures(request.getParameter("prodModelFeatures"));
		pmit.setProdModelPrice(Double.parseDouble(request.getParameter("prodModelPrice")));
		pmit.setProdModelThreshold(Integer.parseInt(request.getParameter("prodModelThreshold")));
		
		try{
			try {
				inventoryDao.addProductModel(pmit);
				rd=request.getRequestDispatcher("JspPages/Add.jsp");
				request.setAttribute("pmit", pmit);
				rd.forward(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (SQLException e) 
		{
				try{
					response.sendRedirect("/Project/JspPages/modelError.jsp");
					}
				 catch (IOException e1) {
				
					e.printStackTrace();
				}
				e.printStackTrace();
		}
		
	}
	
	private void replaceProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException
	{
		List<DefectProductOrder> dPOList = new ArrayList<DefectProductOrder>();
		dPOList=inventoryDao.replaceProd();		
		rd = ctx.getRequestDispatcher("/JspPages/ReplaceProduct.jsp");
		request.setAttribute("List", dPOList);
		rd.forward(request, response);
	}
	
	private void replaceProdInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException
	{
		String defProdCode = request.getParameter("defProdCode");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String repProdCode = inventoryDao.findAvailableProduct(defProdCode);
		System.out.println("replacement prodcode are: "+repProdCode);
		inventoryDao.replaceProduct(defProdCode, repProdCode, orderId);
		
		response.sendRedirect("/Project/JspPages/Home.jsp");
	}
	
	private void viewModel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException 
	{
		List<ProductModelInfoTable> modelList = inventoryDao.updateModelList();
		rd = ctx.getRequestDispatcher("/JspPages/ViewModel.jsp");
		request.setAttribute("modelList", modelList);
		rd.forward(request, response);

	}
	
	private void updateModelList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException 
	{
		List<ProductModelInfoTable> modelList = inventoryDao.updateModelList();
		rd = request.getRequestDispatcher("/JspPages/UpdateModel.jsp");
		request.setAttribute("modelList", modelList);
		rd.forward(request, response);
	}
	
	private void updateModel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException {
    	
    	
		
		String productModelID = request.getParameter("productModelID");
		ProductModelInfoTable pmit = inventoryDao.updateModel(productModelID);
		rd = ctx.getRequestDispatcher("/JspPages/UpdateModelInfo.jsp");
		request.setAttribute("PMIT", pmit);
		rd.forward(request, response);

	}
	
	private void updateModelInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException, NamingException 
	{
	
	
		ProductModelInfoTable productmodelinfotable=new ProductModelInfoTable();
		productmodelinfotable.setProdModelId(request.getParameter("productModelID"));
		productmodelinfotable.setProdModelDesc(request.getParameter("productModelDescription"));
		productmodelinfotable.setProdModelFeatures(request.getParameter("productModelFeature"));
	    productmodelinfotable.setProdModelPrice(Double.parseDouble(request.getParameter("productModelPrice")));
	    productmodelinfotable.setProdModelThreshold(Integer.parseInt(request.getParameter("productModelThreshold")));
		
		inventoryDao.updateModelinfo(productmodelinfotable);
	
		response.sendRedirect("/Project/JspPages/Home.jsp");
	}
	
	private void deleteModel(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException, NamingException
	{ 
		List<ProductModelInfoTable> modelList = inventoryDao.deleteModel();
		rd = ctx.getRequestDispatcher("/Project/JspPages/DeleteModel.jsp");
		request.setAttribute("List", modelList);
		rd.forward(request, response);	
		
	}
	
	private void deleteModelInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException 
	{
		String prodModelId=request.getParameter("sel");
		System.out.println(request.getParameter("sel"));
		inventoryDao.deleteModelInfo(prodModelId);
		
	    response.sendRedirect("/Project/JspPages/Home.jsp");
	}
	
	private void addProductModel(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException, NamingException 
	{
		List<ProductModelInfoTable> modelList=inventoryDao.updateModelList();
		rd = ctx.getRequestDispatcher("/JspPages/AddProduct.jsp");
		request.setAttribute("modelList", modelList);
		rd.forward(request, response);	
	}

	private void addProduct(HttpServletRequest request,HttpServletResponse response)
	{
		ProductStockTable p= new ProductStockTable();
		p.setProdCode(request.getParameter("code"));
		System.out.println(request.getParameter("code"));
		p.setProdModelId(request.getParameter("mid"));
		System.out.println(request.getParameter("mid"));
		Search pst = null;
		try {
			pst = inventoryDao.addProduct(p);
			rd = ctx.getRequestDispatcher("/JspPages/ShowProduct.jsp");
			request.setAttribute("product", pst);
			rd.forward(request, response);
		}catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				response.sendRedirect("/Project/JspPages/productError.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
			

	}

	/*private void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{ 
		List<ProductStockTable> prodList = inventoryDao.deleteProduct();
		rd = ctx.getRequestDispatcher("/JspPages/DeleteProduct.jsp");
		request.setAttribute("List", prodList);
		rd.forward(request, response);		
	}*/
	
	private void deleteProductsCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException 
	{
		String productModelID = request.getParameter("prodModelId");
		ArrayList<ProductStockTable> pmit = inventoryDao.deleteProducts(productModelID);
		RequestDispatcher rd = request.getRequestDispatcher("/JspPages/deleteProductsCheck.jsp");
		request.setAttribute("PMIT", pmit);
		rd.forward(request, response);
	}
	
	public void deleteProductsCheckBox(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException 
	{
		String[] prodIdList=request.getParameterValues("productIds");
		String modelId1=inventoryDao.deleteProducts1(prodIdList);
		System.out.println(modelId1);
		ArrayList<ProductStockTable> pmit = inventoryDao.deleteProducts(modelId1);
		RequestDispatcher rd = request.getRequestDispatcher("/JspPages/deleteProductsCheck1.jsp");
		request.setAttribute("PMIT", pmit);
		rd.forward(request, response);
	}
	
	private void viewProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException 
	{
		String productModelID = request.getParameter("prodModelId");
		ArrayList<ProductStockTable> pmit = inventoryDao.viewProducts(productModelID);
		RequestDispatcher rd = request.getRequestDispatcher("/JspPages/ViewProducts.jsp");
		request.setAttribute("PMIT", pmit);
		rd.forward(request, response);
	}
	
	/*private void deleteProductInfo(HttpServletRequest request,HttpServletResponse response) throws IOException
	{ 
		boolean b=false;
		String code= request.getParameter("sel");
		System.out.println(code);
	    b = inventoryDao.deleteProductInfo(code);
		
		if(b==true)
		{
			response.sendRedirect("/JspPages/Home.jsp");
		}
		else if(b==false)
		{
			response.sendRedirect("/JspPages/Home.jsp");
		}
		
	}*/

	public void tagModel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException 
	{
		List<Retailer> retList=new ArrayList<Retailer>();
		List<ProductModelInfoTable> modelList=new ArrayList<ProductModelInfoTable>();
		modelList=inventoryDao.productModelList();
		retList=inventoryDao.retailerList();
		rd=ctx.getRequestDispatcher("/JspPages/TagModel.jsp");
		request.setAttribute("modelList", modelList);
		request.setAttribute("retList", retList);
		rd.forward(request, response);
	}
	
	private void taggedModels(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException, SQLException
	{
		String[] modelId=request.getParameterValues("modelId");
		String[] retailerId=request.getParameterValues("retailerId");
		
		inventoryDao.tagRetailer(modelId, retailerId);
		
		response.sendRedirect("/Project/JspPages/Home.jsp");
		
	}
	private void tag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException
	{
		List<Retailer> list = new ArrayList<Retailer>();
		list= inventoryDao.tagged();
		RequestDispatcher rd=request.getRequestDispatcher("/JspPages/TagRetailer.jsp");
		request.setAttribute("list1", list);
		rd.forward(request, response);	
	}
	
	private void viewStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException
	{
		List<ProductModelInfoTable> arrList=new ArrayList<ProductModelInfoTable>();
		arrList=inventoryDao.viewModelsStock();
		rd=ctx.getRequestDispatcher("/JspPages/ViewStock.jsp");
		request.setAttribute("list1", arrList);
		rd.forward(request, response);
	}
	
	private void dispatchProducts(HttpServletRequest request, HttpServletResponse response)
	{
		Date dt=new Date();
		try {
			inventoryDao.dispatchDt(dt);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				response.sendRedirect("/Project/JspPages/Dispatch.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			response.sendRedirect("/Project/JspPages/Dispatch.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, StringIndexOutOfBoundsException, NamingException, SQLException
	{
		List<String> modelList = inventoryDao.searchModel();
		List<String> prodList = inventoryDao.searchProduct();
		System.out.println(modelList);
		rd=ctx.getRequestDispatcher("/JspPages/SearchCatalog2.jsp");
		request.setAttribute("modelList", modelList);
		request.setAttribute("prodList", prodList);
		rd.forward(request, response);
	}
	
	private void searchType(HttpServletRequest request, HttpServletResponse response) throws NamingException
	{
		List<String> modelList = null;
		List<String> prodList = null;
		try {
			modelList = inventoryDao.searchModel();
		} catch (StringIndexOutOfBoundsException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			prodList = inventoryDao.searchProduct();
		} catch (StringIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(modelList);
		String action1 = request.getParameter("action1");
		String optionChoosen = request.getParameter("optionChoosen");
		System.out.println("action choosen is "+action1);
		System.out.println("option choosen is "+optionChoosen);
		List<Search> searchList = new ArrayList<Search>();
		try {
			searchList = inventoryDao.searchType(action1, optionChoosen);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Search sList:searchList)
		{	
			System.out.println("Productcode is: "+sList.getProdCode());
		}
		rd=ctx.getRequestDispatcher("/JspPages/SearchCatalog3.jsp");
		request.setAttribute("modelList", modelList);
		request.setAttribute("prodList", prodList);
		request.setAttribute("searchList", searchList);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
