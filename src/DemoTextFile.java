import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DemoTextFile 
{

	public static void main(String[] args) throws IOException 
	{
	
		FileReader fr=new FileReader("d:\\HomePageContent.txt");
		BufferedReader br=new BufferedReader(fr);
		
		String expcontent,actcontent;		
		expcontent=br.readLine();
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com");
		
actcontent=driver.findElement
			(By.xpath("//table/tbody/tr[2]/td[1]/p[1]")).getText();
		if (expcontent.equalsIgnoreCase(actcontent)) 
		{
			System.out.println("Test Pass");
		} else 
		{
			System.out.println("Test Fail");
		}
		
		
		
	}

}
