package com.quinnox.productwebservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
		String url = "jdbc:mysql://database-1.co0gkoh2z93x.ap-south-1.rds.amazonaws.com:3306/demo2";
        String user = "admin";
        String password = "QWEqwe12";
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection    con = DriverManager.getConnection(url, user, password);
    
        return con;
    
}
}