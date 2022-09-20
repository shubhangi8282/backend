package com.quinnox.productwebservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	//fetch
	//public List<Product> productList = new ArrayList<Product>();
	
	
		public List<Product> getProducts() throws ClassNotFoundException, SQLException
		{
			Connection con = ConnectionFactory.getConnection();
			List<Product> product = new ArrayList<Product>();
			String sql = "select * from products";
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while (rs.next()) 
				{
				   Product	b = new Product();
				   b.setId(rs.getInt(1));
				   b.setName(rs.getString(2));
				   b.setPrice(rs.getInt(3));
					
					
					
					
					product.add(b);
					
				}
			
			return product;
		}
		
		public void insertProduct(Product product) throws ClassNotFoundException, SQLException {
	        Connection con = ConnectionFactory.getConnection();
	    //    PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement("insert into fashion(id,type,item_name,item_price)values(?,?,?,?)");
	    String sql = "INSERT INTO products VALUES(?,?,?)";



	       PreparedStatement preparedStmt = con.prepareStatement(sql);



	       preparedStmt.setInt(1, product.getId());
	        preparedStmt.setString(2, product.getName());
	        preparedStmt.setInt(3, product.getPrice());



	       preparedStmt.executeUpdate();



	   }
	    
	        
	        
	          public void updateProduct(Product product) throws Exception{
	          Connection con = ConnectionFactory.getConnection();
	          java.sql.PreparedStatement preparedStmt = con.prepareStatement("update products set name = ? where id =? ");
//	  
	          preparedStmt.setInt(2, product.getId());
//	          preparedStmt.setInt(2,bike.getModel());
	          preparedStmt.setString(1, product.getName());
//	          preparedStmt.executeUpdate();
	          int count = preparedStmt.executeUpdate();
	          System.out.print("updated count:"+count);
	          }
	          
	            
	              public void deleteproduct(int id) throws Exception {
	              Connection con = ConnectionFactory.getConnection();
	              java.sql.PreparedStatement ps =con.prepareStatement("delete from products where id = ? "); // String
	             // queryUpdate = "delete from bike where id = " + id;
	              // PreparedStatement ps  =con.prepareStatement(queryUpdate);
	              ps.setInt(1, id);
	              int count=ps.executeUpdate();
	              System.out.print("updated count:" +count);
	              }
		
	}	

	
