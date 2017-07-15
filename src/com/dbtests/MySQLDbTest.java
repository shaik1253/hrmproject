package com.dbtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySQLDbTest 
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		String dburl,uid,pwd;
		dburl="jdbc:mysql://qedgetech.com:3306/qedge_ohrm1";
		uid="qedgehrm";
		pwd="12345";
				
		Connection dbcon;
		dbcon=DriverManager.getConnection(dburl, uid, pwd);
		
		Statement stmt=dbcon.createStatement();
		ResultSet rs=stmt.executeQuery
						("Select max(emp_number) from hs_hr_employee");
		rs.next();
		int maxempid=rs.getInt(1);
		rs.close();
		dbcon.close();
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://orangehrm.qedgetech.com");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		String actempid=driver.findElement(By.id("employeeId"))
													.getAttribute("value");
		
		String expempid=String.valueOf(maxempid+1);

		if (expempid.equalsIgnoreCase(actempid)) 
		{
			System.out.println("Test Pass");
		} else 
		{
			System.out.println("Test Fail");
		}
	}

}
