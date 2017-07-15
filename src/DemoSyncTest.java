import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoSyncTest 
{

	public static void main(String[] args) 
	{
	
WebDriver driver=new FirefoxDriver();
driver.get("https://www.24hourfitness.com/");
		
WebDriverWait wait=new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.elementToBeClickable
						(By.xpath("//div/div[2]/div[3]/div/a")));

driver.findElement(By.xpath("//div/div[2]/div[3]/div/a")).click();
		
		
	}

}
