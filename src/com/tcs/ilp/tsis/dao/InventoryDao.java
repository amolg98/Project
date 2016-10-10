package com.tcs.ilp.tsis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.naming.NamingException;

import com.tcs.ilp.tsis.model.Login;
import com.tcs.ilp.tsis.model.DefectProductOrder;
import com.tcs.ilp.tsis.model.ProductModelInfoTable;
import com.tcs.ilp.tsis.model.ProductStockTable;
import com.tcs.ilp.tsis.model.Retailer;
import com.tcs.ilp.tsis.model.Search;
import com.tcs.ilp.tsis.dao.DBConnectionUtil;

public class InventoryDao 
{
	static Connection conn = null;
	
	public static Login validateInvManager(Login login) throws SQLException, NamingException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Login loginInv = null;
		conn = DBConnectionUtil.getConnection();
		try {
			ps = conn.prepareStatement("select * from login_gp2 where username=? and password=?");
			ps.setString(1,login.getUsername());
			ps.setString(2,login.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				loginInv = new Login();
				loginInv.setUsername(rs.getString(1));
				loginInv.setRole(rs.getString(3));				
			}
						
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			ps.close();
			DBConnectionUtil.closeConnection(conn);
		}
		return loginInv;
	}
	
	public void addProductModel(ProductModelInfoTable pmit) throws NamingException, SQLException
	{
		
		PreparedStatement pstmt = null;
		System.out.println("Enter the connection");
		
			conn = DBConnectionUtil.getConnection();
			String query = "insert into prodModelInfo values(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, pmit.getProdModelId());
			pstmt.setString(2, pmit.getProdModelName());
			pstmt.setString(3, pmit.getProdModelDesc());
			pstmt.setString(4, pmit.getProdModelFeatures());
			pstmt.setDouble(5, pmit.getProdModelPrice());
			pstmt.setInt(6, pmit.getProdModelThreshold());
			
			pstmt.executeUpdate();	
			
			System.out.println("Still going...");
		
		
		
				pstmt.close();
				DBConnectionUtil.closeConnection(conn);
			
		System.out.println("Out..");
	}
	
	public List<DefectProductOrder> replaceProd() throws NamingException
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DefectProductOrder> dPO = new ArrayList<DefectProductOrder>();
		DefectProductOrder defProdOr = new DefectProductOrder();
		System.out.println("Enter the connection");
		
		try
		{
			conn = DBConnectionUtil.getConnection();
			
			String query = "select * from defProdOrder where replacementProdCode is null";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();	
			
			System.out.println("Still going...");
			
			while(rs.next())
			{
				defProdOr = new DefectProductOrder();
				defProdOr.setOrderId(rs.getString(1));
				defProdOr.setDefectProdCode(rs.getString(2));
				defProdOr.setReason(rs.getString(3));
				defProdOr.setReplacementProdCode(rs.getString(4));
				dPO.add(defProdOr);
			}
		} 
		catch (SQLException e) 
		{
			try
			{
				conn.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				DBConnectionUtil.closeConnection(conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
		return dPO;
	}

	public String findAvailableProduct(String prodCode) throws NamingException
	{
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String modelId = null;
		String repProdCode = null;
		System.out.println("Enter the connection");
		
		try
		{	
			conn = DBConnectionUtil.getConnection();
			String query1 ="Select * from prodStockTable where prodCode=?";
			pstmt1 = conn.prepareStatement(query1);
			pstmt1.setString(1, prodCode);
			rs=pstmt1.executeQuery();
			while(rs.next())
			{
				modelId = rs.getString(2);
			}
			System.out.println(modelId);
			
			String query = "select prodCode from prodStockTable where prodModelStatus='Available' and prodmodelid=?";
			System.out.println(">>>>> Connection ::: "+conn);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, modelId);
			rs1=pstmt.executeQuery();	
			
			System.out.println("Still going...");
			
			while(rs1.next())
			{
				repProdCode  = rs1.getString(1);
			}
			System.out.println(repProdCode);
		
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				pstmt1.close();
				DBConnectionUtil.closeConnection(conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
		return repProdCode;
	}
	
	public void replaceProduct(String defProCod, String repProCod, int orderId) throws NamingException
	{
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		System.out.println("Enter the connection");
		System.out.println(defProCod);
		System.out.println(orderId);
		System.out.println(repProCod);
		
		try
		{
			conn = DBConnectionUtil.getConnection();
			String query = "update defProdOrder set replacementProdCode=? where defectProdCode=?";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, repProCod); 
			pstmt.setString(2, defProCod);
			pstmt.executeUpdate();	
			
			String query1 = "update prodStockTable set prodModelStatus=?, orderId=? where prodCode=?";
			
			pstmt1 = conn.prepareStatement(query1);
			
			pstmt1.setString(1, "Allocated"); 
			pstmt1.setInt(2, orderId);
			pstmt1.setString(3, repProCod);
			pstmt1.executeUpdate();	
			
			String query2 = "update prodStockTable set prodModelStatus=? where prodCode=?";
			
			pstmt2 = conn.prepareStatement(query2);
			
			pstmt2.setString(1, "Defected"); 
			pstmt2.setString(2, defProCod);
			pstmt2.executeUpdate();	
			
			System.out.println("Still going...");
		
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				pstmt1.close();
				pstmt2.close();
				DBConnectionUtil.closeConnection(conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
	}
	
	public List<ProductModelInfoTable> updateModelList() throws NamingException
	{
		ArrayList<ProductModelInfoTable> aList=new ArrayList<ProductModelInfoTable>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{   
			conn = DBConnectionUtil.getConnection();
			String sql="Select * from prodModelInfo";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ProductModelInfoTable pm=new ProductModelInfoTable();
				pm.setProdModelId(rs.getString(1));
				pm.setProdModelName(rs.getString(2));
				pm.setProdModelDesc(rs.getString(3));
				pm.setProdModelFeatures(rs.getString(4));
				pm.setProdModelPrice(rs.getDouble(5));
				pm.setProdModelThreshold(rs.getInt(6));
				aList.add(pm);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	try
	    	{
	    		pstmt.close();
	    		DBConnectionUtil.closeConnection(conn);
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return aList;
	}
	
	public ArrayList<ProductStockTable> deleteProducts(String modelId) throws NamingException
	{
		ArrayList<ProductStockTable> aList=new ArrayList<ProductStockTable>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{   
			conn = DBConnectionUtil.getConnection();
			String modelId1 = "%"+modelId+"%";
			String sql="Select * from prodStockTable where prodModelId like ? and PRODMODELSTATUS=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, modelId1);
			pstmt.setString(2, "Available");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ProductStockTable p=new ProductStockTable();
				p.setProdCode(rs.getString(1));
				p.setProdModelId(rs.getString(2));
				p.setProdModelName(rs.getString(3));
				p.setProdModelStatus(rs.getString(4));
				aList.add(p);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	try
	    	{
	    		pstmt.close();
	    		DBConnectionUtil.closeConnection(conn);
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return aList;
	}
	
	public ArrayList<ProductStockTable> viewProducts(String modelId) throws NamingException
	{
		ArrayList<ProductStockTable> aList=new ArrayList<ProductStockTable>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{   
			conn = DBConnectionUtil.getConnection();
			String modelId1 = "%"+modelId+"%";
			String sql="Select * from prodStockTable where prodModelId like ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, modelId1);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ProductStockTable p=new ProductStockTable();
				p.setProdCode(rs.getString(1));
				p.setProdModelId(rs.getString(2));
				p.setProdModelName(rs.getString(3));
				p.setProdModelStatus(rs.getString(4));
				aList.add(p);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	try
	    	{
	    		pstmt.close();
	    		DBConnectionUtil.closeConnection(conn);
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return aList;
	}
	
	public String deleteProducts1(String[] prodCode) throws NamingException
	{
		
		PreparedStatement pstmt=null;
		ProductStockTable pst=new ProductStockTable();
		ResultSet rs=null;
		
		try
		{   
			conn = DBConnectionUtil.getConnection();
			String sql2="select PRODMODELID from PRODSTOCKTABLE WHERE PRODCODE=?";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, prodCode[0]);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				pst.setProdModelId(rs.getString(1));
			}
			for(String str:prodCode)
			{
				String str1="delete from prodStockTable where prodcode=?";
				pstmt=conn.prepareStatement(str1);
				pstmt.setString(1, str);
				pstmt.executeUpdate();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	try
	    	{
	    		pstmt.close();
	    		DBConnectionUtil.closeConnection(conn);
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	return pst.getProdModelId();
	}
	
	public ProductModelInfoTable updateModel(String productModelID) throws NamingException
	{
		
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		ProductModelInfoTable pmit=new ProductModelInfoTable();
		
		String sql="select * from prodModelInfo where prodModelId=?";
		
		try 
		{
			conn = DBConnectionUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,productModelID);
			rs=pstmt.executeQuery();
				
			while(rs.next())
			{	
				pmit.setProdModelId(rs.getString(1));
				pmit.setProdModelName(rs.getString(2));
				pmit.setProdModelDesc(rs.getString(3));
				pmit.setProdModelFeatures(rs.getString(4));
				pmit.setProdModelPrice(rs.getDouble(5));
				pmit.setProdModelThreshold(rs.getInt(6));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				pstmt.close();
				DBConnectionUtil.closeConnection(conn);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
 	  	System.out.println("Id is: "+pmit.getProdModelId());
 	  	return pmit;

	}	
		
 	public void updateModelinfo(ProductModelInfoTable pmi) throws NamingException
 	{
 		PreparedStatement pstmt=null;	
		
 		String sql="update prodModelInfo set prodModelDesc=?, prodModelFeatures=?, prodModelPrice=?, prodModelThreshold=? where prodModelId=?";
		 
 		try 
 		{
 			conn = DBConnectionUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,pmi.getProdModelDesc());
			pstmt.setString(2,pmi.getProdModelFeatures());
			pstmt.setDouble(3, pmi.getProdModelPrice());
			pstmt.setInt(4,pmi.getProdModelThreshold());
			pstmt.setString(5,pmi.getProdModelId());
			pstmt.executeUpdate();
		
 		}
 		catch(SQLException e)
		{
 			e.printStackTrace();
		}
 		finally 
 		{
 			try 
 			{
 				pstmt.close();
 				DBConnectionUtil.closeConnection(conn);
 			} 
 			catch (SQLException e) 
 			{
 				e.printStackTrace();
 			}
 		}
 	}
 		
 	public Search addProduct(ProductStockTable pd) throws NamingException, SQLException
	{
 		PreparedStatement pstmt = null;
 		ResultSet rs1 = null;
 		ResultSet rs = null;
 		PreparedStatement pstmt1 = null;
 		PreparedStatement pstmt2 = null;
 		Search pst = new Search();
 		String prodModelname = null;
 			conn = DBConnectionUtil.getConnection();
			pstmt2 = conn.prepareStatement("select * from prodModelInfo where prodmodelid=?");
			pstmt2.setString(1, pd.getProdModelId());
			rs=pstmt2.executeQuery();
			while(rs.next())
			{
				prodModelname = rs.getString(2);
			}
			
			System.out.println(prodModelname);
			
			pstmt = conn.prepareStatement("insert into prodStockTable values(?,?,?,?,null)");
			pstmt.setString(1, pd.getProdCode());
			pstmt.setString(2, pd.getProdModelId());
			pstmt.setString(3, prodModelname);
			pstmt.setString(4, "Available");
			pstmt.executeUpdate();
			
			pstmt1 = conn.prepareStatement("select * from prodStockTable p, prodModelInfo m where p.prodmodelid=m.prodmodelid and p.prodcode=?");
			pstmt1.setString(1, pd.getProdCode());
			rs1=pstmt1.executeQuery();
			while(rs1.next())
			{
				pst = new Search();
				pst.setProdCode(rs1.getString(1));
				pst.setProdModelId(rs1.getString(2));
				pst.setProdModelName(rs1.getString(3));
				pst.setProdModelStatus(rs1.getString(4));
				pst.setProdModelDesc(rs1.getString(8));
				pst.setProdModelFeatures(rs1.getString(9));
				pst.setProdModelPrice(rs1.getFloat(10));
			}
			pstmt.close();
			pstmt1.close();
			pstmt2.close();
			DBConnectionUtil.closeConnection(conn);
		System.out.println(pst.getProdCode());
		return pst;
	}
	
 	/*public List<ProductStockTable> deleteProduct()
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductStockTable> prodList = new ArrayList<ProductStockTable>();
		ProductStockTable prodStTb = new ProductStockTable();
		System.out.println("Enter the connection");
		
		try
		{
			String query = "select * from prodStockTable";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();	
			System.out.println("Still going...");
			
			while(rs.next())
			{
				prodStTb = new ProductStockTable();
				prodStTb.setProdCode(rs.getString(1));
				prodStTb.setProdModelId(rs.getString(2));
				prodStTb.setProdModelName(rs.getString(3));
				prodStTb.setProdModelStatus(rs.getString(4));
				prodStTb.setOrderId(rs.getInt(5));
				prodList.add(prodStTb);
			}
		
		} 
		catch (SQLException e) 
		{
			try
			{
				conn.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
		return prodList;
	}*/
 		
 	/*public boolean deleteProductInfo(String code)
	{
 		PreparedStatement pstmt = null;  
		Connection con = null;
		try
		{
			con =  DBConnectionUtil.getConnection();
			pstmt= con.prepareStatement("select * from prodStockTable where prodCode=?");
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("prodModelStatus").equals("Available"))
				{
					pstmt = con.prepareStatement("delete  from prodStockTable where  prodCode=?" );
					pstmt.setString(1, code);
					pstmt.executeUpdate();
				}
				else
				{
					return false;
				}
			}
		}
		catch (SQLException e) 
		{
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				DBConnectionUtil.closeConnection(con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return true;
		
	}*/

 	public List<ProductModelInfoTable> deleteModel() throws NamingException
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductModelInfoTable> modelList = new ArrayList<ProductModelInfoTable>();
		ProductModelInfoTable modelTb = new ProductModelInfoTable();
		System.out.println("Enter the connection");
		try
		{
			conn = DBConnectionUtil.getConnection();
			String query = "select * from prodModelInfo";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();	
			System.out.println("Still going...");
			
			while(rs.next())
			{
				modelTb = new ProductModelInfoTable();
				modelTb.setProdModelId(rs.getString(1));
				modelTb.setProdModelName(rs.getString(2));
				modelTb.setProdModelDesc(rs.getString(3));
				modelTb.setProdModelFeatures(rs.getString(4));
				modelTb.setProdModelPrice(rs.getDouble(5));
				modelTb.setProdModelThreshold(rs.getInt(6));
				modelList.add(modelTb);
			}		
		} 
		catch (SQLException e) 
		{
			try
			{
				conn.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				DBConnectionUtil.closeConnection(conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
		return modelList;
	}

 	public void deleteModelInfo(String prodModelId) throws NamingException, SQLException
 	{
 		ResultSet rs=null;
 		PreparedStatement pstmt=null;
 		conn=DBConnectionUtil.getConnection();	
		
 		String query1="select * from prodStockTable where prodModelId=? and prodModelStatus='Allocated'";
	
 		try 
 		{
 			pstmt=conn.prepareStatement(query1);
			pstmt.setString(1,prodModelId);
			rs= pstmt.executeQuery();
			if(rs.next())
 			{
				System.out.println("Products of this model are allocated");
				//return false;
			}
			else
			{
				PreparedStatement pstmt1=null;
				String query2="delete from retailer where prodModelId=?";
			 
 				try 
 				{
 					pstmt1=conn.prepareStatement(query2);
					pstmt1.setString(1,prodModelId);
					pstmt1.executeUpdate();
				} 
 				catch(SQLException e) 
 				{
					e.printStackTrace();
 				}
 				finally 
 				{
 					try 
 					{
 						System.out.println("Closing the conn1....");
 						pstmt1.close();
 					} 
 					catch(SQLException e)
 					{
 						e.printStackTrace();
 					}
 				}
			 
				PreparedStatement pstmt2=null;
				String query3="delete from prodStockTable where prodModelId=?";
 				System.out.println("prodStock");
 				try 
 				{
 					pstmt2=conn.prepareStatement(query3);
					pstmt2.setString(1,prodModelId);
					pstmt2.executeUpdate();
				} 
 				catch(SQLException e) 
 				{
					e.printStackTrace();
				}
 				finally 
 				{
 					try 
 					{
 						System.out.println("Closing the conn2....");
 						pstmt2.close();
					} 
 					catch(SQLException e) 
 					{
 						e.printStackTrace();
					}
 				}
			 
 				PreparedStatement pstmt3=null;
				String query4="delete from prodModelInfo where prodModelId=?";
	
 				try 
 				{
 					pstmt3=conn.prepareStatement(query4);
					pstmt3.setString(1,prodModelId);
					pstmt3.executeUpdate();
				}
 				catch(SQLException e) 
 				{
					e.printStackTrace();
				}
 				finally 
 				{
 					try 
 					{
 						System.out.println("Closing the conn3....");
 						pstmt3.close();
 					} 
 					catch(SQLException e)
 					{
 						e.printStackTrace();
 					}
 				}
			}
 		} 
 		catch(SQLException e) 
 		{
 			e.printStackTrace();
		}
 		finally 
 		{
 			try 
 			{
 				System.out.println("Closing the starting conn....");
 				pstmt.close();
 				DBConnectionUtil.closeConnection(conn);
			} 
 			catch(SQLException e) 
 			{
 				e.printStackTrace();
			}
 		}
	//return true;
 	}

 	public List<ProductModelInfoTable> productModelList() throws NamingException, SQLException
	{
		conn=DBConnectionUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductModelInfoTable> pmList=new ArrayList<ProductModelInfoTable>();
		try
		{   
			String sql1="select prodModelId from prodModelInfo";
			pstmt=conn.prepareStatement(sql1);
			rs=pstmt.executeQuery();
			while(rs.next())
			{   
				ProductModelInfoTable pm1=new ProductModelInfoTable();
				pm1.setProdModelId(rs.getString(1));
				pmList.add(pm1);
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	try
	    	{
	    		pstmt.close();
	    		DBConnectionUtil.closeConnection(conn);
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return 	pmList;
	}	
 	
 	public List<Retailer> retailerList() throws NamingException, SQLException
	{
		conn=DBConnectionUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Retailer> rList=new ArrayList<Retailer>();
		try
		{   
			String sql2="select RETAILER_ID from RETAILER_GP2";
			pstmt=conn.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Retailer r1=new Retailer();
				r1.setRetailerId(rs.getString(1));
				rList.add(r1);
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	pstmt.close();
	    	DBConnectionUtil.closeConnection(conn);
	    }
		return 	rList;
	}
 	
 	public void tagRetailer(String[] modelId, String[] retailerId) throws NamingException, SQLException
 	{
 		conn = DBConnectionUtil.getConnection();
 		PreparedStatement pstmt = null;
 		Date dt=new Date();
 		java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
 		try
 		{
 			pstmt=conn.prepareStatement("SELECT PRODUCT_MODEL_ID, RETAILER_ID from RET_PRODUCTMODEL_TBL");
	 		ResultSet rs=pstmt.executeQuery();
	 		ArrayList<String> pmIdList=new ArrayList<String>();
	 		ArrayList<String> rIdList=new ArrayList<String>();
	 		
	 		while(rs.next())
	 		{
	 			pmIdList.add(rs.getString(1));
	 			rIdList.add(rs.getString(2));
	 		}
	 		PreparedStatement st1 = null;
	 		for(String s2:retailerId)
	 		{
		 		for(String s1:modelId)
		 		{  
		 			int k=0;
		 			for(int i=0;i<pmIdList.size();i++)
		 			{
		 				if((s2.equals(rIdList.get(i)))&&(s1.equals(pmIdList.get(i))))
		 				{
	 					     k++;
	 					     break;
	 					}
		 			}
		 			if(k==0)
		 			{		
				 		st1=conn.prepareStatement("insert into RET_PRODUCTMODEL_TBL values(?,?,?)");
				 		st1.setString(1,s1);
				 		st1.setString(2,s2);
				 		st1.setDate(3,sqlDate);
				 		st1.executeUpdate();
		 			}
		 		}
	 		}
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}
 		finally 
 		{
 			try 
 			{
 				System.out.println("Closing the conn2....");
 				pstmt.close();
 		    	DBConnectionUtil.closeConnection(conn);
			} 
 			catch(SQLException e) 
 			{
 				e.printStackTrace();
			}
		}
 	}
 	
 	public List<Retailer> tagged() throws NamingException, SQLException
 	{
 		List<Retailer> list = new ArrayList<Retailer>();
 		Retailer tag= new Retailer();
 		PreparedStatement pstmt=null;
 		conn = DBConnectionUtil.getConnection();
		ResultSet rs=null;
		try
		{   
			String sql="select * from ret_productModel_tbl";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				tag = new Retailer();
				tag.setRetailerId(rs.getString(1));
				tag.setProductModelId(rs.getString(2));
				tag.setTaggeddate(rs.getDate(3));
				list.add(tag);					
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
 		}
		finally
		{
			try
			{
				pstmt.close();
		    	DBConnectionUtil.closeConnection(conn);				
 		    }
			catch(SQLException e)
			{
				e.printStackTrace();
 		    }
		}
		return list;
 	}
 	
 	public List<ProductModelInfoTable> viewModelsStock() throws NamingException, SQLException
	{
		ArrayList<ProductModelInfoTable> aList=new ArrayList<ProductModelInfoTable>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn = DBConnectionUtil.getConnection();
		try
		{   
			String sql="select m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold,count(p.prodCode) from prodModelInfo m,prodStockTable p where m.prodModelId=p.prodModelId and p.prodModelStatus=? group by m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "Available");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ProductModelInfoTable pm=new ProductModelInfoTable();
				pm.setProdModelId(rs.getString(1));
				pm.setProdModelName(rs.getString(2));
				pm.setProdModelDesc(rs.getString(3));
				pm.setProdModelFeatures(rs.getString(4));
				pm.setProdModelPrice(rs.getDouble(5));
				pm.setProdModelThreshold(rs.getInt(6));
				pm.setProdModelThreshold1(rs.getInt(7));
				aList.add(pm);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	    finally
	    {
	    	try
	    	{
	    		pstmt.close();
		    	DBConnectionUtil.closeConnection(conn);
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		return aList;
	}
 	
 	public void dispatchDt(java.util.Date date) throws NamingException, SQLException
	{
		conn=DBConnectionUtil.getConnection();
		PreparedStatement pstmt=null;
		Date dt1=date;
		java.sql.Date sqlDate = new java.sql.Date(dt1.getTime());
		ResultSet rs=null;
		  
			String sql1="select p.prodCode,o.order_Id from prodStockTable p,order_GP2 o where p.orderId=o.order_Id and o.delivery_Date<=? and p.prodModelStatus=? ";
			pstmt=conn.prepareStatement(sql1);	
			pstmt.setDate(1, sqlDate);
			pstmt.setString(2, "Allocated");
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				PreparedStatement pstmt1=null;
				PreparedStatement pstmt2=null;
				
				String sql2="update  prodStockTable set prodModelStatus=? where prodCode=?";
				String sql3="update order_GP2 set Status=? where order_Id=?";
				pstmt1=conn.prepareStatement(sql2);
				pstmt1.setString(1, "Dispatched");
				pstmt1.setString(2, rs.getString(1));
				pstmt1.executeUpdate();
				pstmt2=conn.prepareStatement(sql3);
				pstmt2.setString(1,"Closed");
				pstmt2.setString(2, rs.getString(2));
				pstmt2.executeUpdate();
				
				pstmt1.close();
		    	pstmt2.close();
		    	
			}
			
			
            	
		pstmt.close();
    	DBConnectionUtil.closeConnection(conn);
   
		
}

 	public List<String> searchModel() throws StringIndexOutOfBoundsException, NamingException, SQLException
 	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> modelList = new ArrayList<String>();
		HashSet<String> modelList1 = new HashSet<String>();
		List<String> modelList2 = new ArrayList<String>();
		System.out.println("Enter the connection");
		conn = DBConnectionUtil.getConnection();
		
		try
		{
			String query = "select * from prodModelInfo";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();	
			System.out.println("Still going...");
			
			while(rs.next())
			{
				modelList.add(rs.getString(2));
			}
			for(String mList:modelList)
			{
				int a = 0;
				a = mList.indexOf(' ');
//				try
//				{
					if(a>0)
					{
						System.out.println(a);
						System.out.println(mList);
						String model = mList.substring(0, a);
						modelList1.add(model);	
					}
					else
					{
						modelList1.add(mList);
					}
				//}
				/*catch(Exception e)
				{
					
				}*/
				
			}
			for(String mList1:modelList1)
			{
				modelList2.add(mList1);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
		    	DBConnectionUtil.closeConnection(conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
		System.out.println(modelList2);
		return modelList2;
 	}
 	
 	public List<String> searchProduct() throws StringIndexOutOfBoundsException, NamingException, SQLException
 	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> prodList = new ArrayList<String>();
		HashSet<String> prodList1 = new HashSet<String>();
		List<String> prodList2 = new ArrayList<String>();
		System.out.println("Enter the connection");
		conn = DBConnectionUtil.getConnection();
		
		try
		{
			String query = "select * from prodModelInfo";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();	
			System.out.println("Still going...");
			
			while(rs.next())
			{
				prodList.add(rs.getString(2));
			}
			for(String pList:prodList)
			{
				int a = pList.indexOf(' ')+1;
				if(a-1>0)
				{
					int c = pList.length();
					String prod = pList.substring(a, c);
					int b = prod.indexOf(' ');
					String prod1 = prod.substring(0,b);
					prodList1.add(prod1);	
				}
			}
			for(String pList1:prodList1)
			{
				prodList2.add(pList1);
			}
			System.out.println(prodList2);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
		    	DBConnectionUtil.closeConnection(conn);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		System.out.println("Out..");
		return prodList2;
 	}

 	public List<Search> searchType(String action1, String optionChoosen) throws NamingException, SQLException
 	{
 		conn = DBConnectionUtil.getConnection();
 		ArrayList<Search> searchList=new ArrayList<Search>();
 		Search search = new Search();
 		if(action1.equalsIgnoreCase("Brand"))
		{
 			System.out.println(optionChoosen);
 			PreparedStatement pstmt=null;
 			ResultSet rs=null;
 			try
 			{   
 				String optionChoosen1 = "%"+optionChoosen+"%";
 				String sql="select m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold,p.prodCode,p.prodModelStatus from prodModelInfo m,prodStockTable p where m.prodModelId=p.prodModelId and p.prodModelStatus=? and p.prodModelName like ?";
 				pstmt=conn.prepareStatement(sql);
 				pstmt.setString(1, "Available");
 				pstmt.setString(2, optionChoosen1);
 				rs=pstmt.executeQuery();
 				while(rs.next())
 				{
 					search = new Search();
 					search.setProdModelId(rs.getString(1));
 					search.setProdModelName(rs.getString(2));
 					search.setProdModelDesc(rs.getString(3));
 					search.setProdModelFeatures(rs.getString(4));
 					search.setProdModelPrice(rs.getFloat(5));
 					search.setProdModelThreshold(rs.getInt(6));
 					search.setProdCode(rs.getString(7));
 					search.setProdModelStatus(rs.getString(8));
 					searchList.add(search);
 				}
 			}
 			catch(SQLException se)
 			{
 				se.printStackTrace();
 			}
 		    finally
 		    {
 		    	try
 		    	{
 		    		pstmt.close();
 		    	}
 		    	catch(SQLException e)
 		    	{
 		    		e.printStackTrace();
 		    	}
 		    }
		}
		else if(action1.equalsIgnoreCase("Product"))
		{
			PreparedStatement pstmt=null;
 			ResultSet rs=null;
 			try
 			{   
 				String optionChoosen1 = "%"+optionChoosen+"%";
 				String sql="select m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold,p.prodCode,p.prodModelStatus from prodModelInfo m,prodStockTable p where m.prodModelId=p.prodModelId and p.prodModelStatus=? and p.prodModelName like ?";
 				pstmt=conn.prepareStatement(sql);
 				pstmt.setString(1, "Available");
 				pstmt.setString(2, optionChoosen1);
 				rs=pstmt.executeQuery();
 				while(rs.next())
 				{
 					search = new Search();
 					search.setProdModelId(rs.getString(1));
 					search.setProdModelName(rs.getString(2));
 					search.setProdModelDesc(rs.getString(3));
 					search.setProdModelFeatures(rs.getString(4));
 					search.setProdModelPrice(rs.getFloat(5));
 					search.setProdModelThreshold(rs.getInt(6));
 					search.setProdCode(rs.getString(7));
 					search.setProdModelStatus(rs.getString(8));
 					searchList.add(search);
 				}
 			}
 			catch(SQLException se)
 			{
 				se.printStackTrace();
 			}
 		    finally
 		    {
 		    	try
 		    	{
 		    		pstmt.close();
 		    	}
 		    	catch(SQLException e)
 		    	{
 		    		e.printStackTrace();
 		    	}
 		    }
		}
		else if(action1.equalsIgnoreCase("Features"))
		{
			PreparedStatement pstmt=null;
 			ResultSet rs=null;
 			try
 			{   
 				String optionChoosen1 = "%"+optionChoosen+"%";
 				String sql="select m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold,p.prodCode,p.prodModelStatus from prodModelInfo m,prodStockTable p where m.prodModelId=p.prodModelId and p.prodModelStatus=? and m.prodModelFeatures like ?";
 				pstmt=conn.prepareStatement(sql);
 				pstmt.setString(1, "Available");
 				pstmt.setString(2, optionChoosen1);
 				rs=pstmt.executeQuery();
 				while(rs.next())
 				{
 					search = new Search();
 					search.setProdModelId(rs.getString(1));
 					search.setProdModelName(rs.getString(2));
 					search.setProdModelDesc(rs.getString(3));
 					search.setProdModelFeatures(rs.getString(4));
 					search.setProdModelPrice(rs.getFloat(5));
 					search.setProdModelThreshold(rs.getInt(6));
 					search.setProdCode(rs.getString(7));
 					search.setProdModelStatus(rs.getString(8));
 					searchList.add(search);
 				}
 			}
 			catch(SQLException se)
 			{
 				se.printStackTrace();
 			}
 		    finally
 		    {
 		    	try
 		    	{
 		    		pstmt.close();
 		    	}
 		    	catch(SQLException e)
 		    	{
 		    		e.printStackTrace();
 		    	}
 		    }

		}
		else if(action1.equalsIgnoreCase("Price"))
		{
			PreparedStatement pstmt=null;
 			ResultSet rs=null;
 			try
 			{   
 				String sql="select m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold,p.prodCode,p.prodModelStatus from prodModelInfo m,prodStockTable p where m.prodModelId=p.prodModelId and p.prodModelStatus=? and m.prodModelPrice<?";
 				pstmt=conn.prepareStatement(sql);
 				pstmt.setString(1, "Available");
 				pstmt.setInt(2, Integer.parseInt(optionChoosen));
 				rs=pstmt.executeQuery();
 				while(rs.next())
 				{
 					search = new Search();
 					search.setProdModelId(rs.getString(1));
 					search.setProdModelName(rs.getString(2));
 					search.setProdModelDesc(rs.getString(3));
 					search.setProdModelFeatures(rs.getString(4));
 					search.setProdModelPrice(rs.getFloat(5));
 					search.setProdModelThreshold(rs.getInt(6));
 					search.setProdCode(rs.getString(7));
 					search.setProdModelStatus(rs.getString(8));
 					searchList.add(search);
 				}
 			}
 			catch(SQLException se)
 			{
 				se.printStackTrace();
 			}
 		    finally
 		    {
 		    	try
 		    	{
 		    		pstmt.close();
 		    	}
 		    	catch(SQLException e)
 		    	{
 		    		e.printStackTrace();
 		    	}
 		    }
		}
		else if(action1.equalsIgnoreCase("Status"))
		{
			PreparedStatement pstmt=null;
 			ResultSet rs=null;
 			try
 			{   
 				String sql="select m.prodModelId,m.prodModelName,m.prodModelDesc,m.prodModelFeatures,m.prodModelPrice,m.prodModelThreshold,p.prodCode,p.prodModelStatus from prodModelInfo m,prodStockTable p where m.prodModelId=p.prodModelId and p.prodModelStatus=?";
 				pstmt=conn.prepareStatement(sql);
 				pstmt.setString(1, optionChoosen);
 				rs=pstmt.executeQuery();
 				while(rs.next())
 				{
 					search = new Search();
 					search.setProdModelId(rs.getString(1));
 					search.setProdModelName(rs.getString(2));
 					search.setProdModelDesc(rs.getString(3));
 					search.setProdModelFeatures(rs.getString(4));
 					search.setProdModelPrice(rs.getFloat(5));
 					search.setProdModelThreshold(rs.getInt(6));
 					search.setProdCode(rs.getString(7));
 					search.setProdModelStatus(rs.getString(8));
 					searchList.add(search);
 				}
 			}
 			catch(SQLException se)
 			{
 				se.printStackTrace();
 			}
 		    finally
 		    {
 		    	try
 		    	{
 		    		pstmt.close();
 		    		DBConnectionUtil.closeConnection(conn);
 		    	}
 		    	catch(SQLException e)
 		    	{
 		    		e.printStackTrace();
 		    	}
 		    }
		}
 		return searchList;
 	}
 	
 	
}
