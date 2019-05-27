package testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverDemo 
{
   public static void main(String[] args) 
   {
	   	System.setProperty("webdriver.gecko.driver", "/home/mmrosa/MEGA/MEGAsync/Faculdade/20191/COMP3/programas/geckodriver");
	   	WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://google.com";
		String expectedTitle = "Google";
		String actualTitle = "";
		
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		
		if(actualTitle.contentEquals(expectedTitle)) 
		{
			System.out.println("Test Passed!");
		}else {
			System.out.println("Test Failed!");
		}
		driver.close();
		System.exit(0);
    
   }
   
   
}