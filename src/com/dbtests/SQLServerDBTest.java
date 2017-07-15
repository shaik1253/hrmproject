package com.dbtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SQLServerDBTest 
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
	
//Step 1: Establishing DB Connection		
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
												.newInstance();
String dburl,uid,pwd;
dburl="jdbc:sqlserver://primusbank.qedgetech.com:1433;" +
												"database=bankdb";
uid="qedge";
pwd="qedge";
		
Connection dbcon;		
dbcon=DriverManager.getConnection(dburl, uid, pwd);
		
//Step 2: Sending SQL Queries
Statement stmt=dbcon.createStatement();
ResultSet rs=stmt.executeQuery("Select count(*) from bankbranches");
//Step 3: Retrive data from ResultSet
		rs.next();
		int expcount=rs.getInt(1);
		rs.close();
		dbcon.close();

    WebDriver driver=new FirefoxDriver();
    driver.get("http://primusbank.qedgetech.com");
    Select blist=new Select(driver.findElement(By.id("drlist")));
    List<WebElement> branches= blist.getOptions();
    int actcount=branches.size()-1;
    if (expcount==actcount) 
    {
    	System.out.println("Test Pass");
	} else 
	{
		System.out.println("Test Fail");
	}
		
		
	}

}
