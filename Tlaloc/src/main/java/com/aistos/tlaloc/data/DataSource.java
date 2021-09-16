package com.aistos.tlaloc.data;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {
	
    private static DataSource datasource;
    private ComboPooledDataSource comboPooledDataSource;

    private String dbDriverClass = "";
    private String dbUrl = "";
    private String dbUser = "";
    private String dbPassword = "";
    
    private DataSource() throws IOException, SQLException, PropertyVetoException {
    	comboPooledDataSource = new ComboPooledDataSource();
    }
    
    private void initProperties(){
    	Properties prop = new Properties();
    	InputStream input;
		try {
			input = new FileInputStream("mysql.config.properties");
			prop.load(input);
		} catch (IOException e) { e.printStackTrace();}
  
   		this.dbDriverClass = prop.getProperty("driverclass");
   		this.dbUrl = prop.getProperty("dburl");
   		this.dbUser = prop.getProperty("dbuser");
   		this.dbPassword = prop.getProperty("dbpassword");
    }
    
    private void initComboPooledDataSource(){
    	try {
    		this.comboPooledDataSource.setDriverClass(this.dbDriverClass);
		} catch (PropertyVetoException e) {e.printStackTrace();} 
    	
    	this.comboPooledDataSource.setJdbcUrl(this.dbUrl);
    	this.comboPooledDataSource.setUser(this.dbUser);
    	this.comboPooledDataSource.setPassword(this.dbPassword);
    	this.comboPooledDataSource.setMinPoolSize(3);
    	this.comboPooledDataSource.setMaxPoolSize(20);
    	this.comboPooledDataSource.setMaxStatements(180);
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            datasource.initProperties();
            datasource.initComboPooledDataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.comboPooledDataSource.getConnection();
    }	
}
