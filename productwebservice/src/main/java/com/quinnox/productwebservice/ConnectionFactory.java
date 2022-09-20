package com.quinnox.productwebservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/demo2";
        String user = "root";
        String password = "root";
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection    con = DriverManager.getConnection(url, user, password);
    
        return con;
    
}
}