package Automation;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import javax.swing.JOptionPane;



public class Facebook_Firefox{
	
public WebDriver driver;
	
	String USERNAME="YourUserName";
	String PASSWORD="YourPassword";
	
	@Test(priority=1)
		public void OpenBrowser(){	

System.setProperty("webdriver.gecko.driver","C:\\Automation\\geckodriver.exe");
		 driver = new FirefoxDriver();
		}
	

	@Test(priority=2)
		public void OpenGoogle() {

		 driver.get("https://www.Google.lk");
		 driver.manage().window().maximize();
		}

	
	@Test(priority=3)
		public void SearchFacebook(){   
 
		 driver.findElement(By.id("lst-ib")).sendKeys("Facebook");
		 driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);	    
		}
	
	@Test(priority=4)
		public void SelectFacebook(){

		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[contains(text(),'Facebook - Log In or Sign Up')]")).click();	
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	

	@Test(priority=5)
		public void InputUsernamePassword(){	

		    driver.findElement(By.id("email")).sendKeys(USERNAME);
		    driver.findElement(By.id("pass")).sendKeys(PASSWORD);
		}

	 
	 @Test(priority=6)
		 public void Login(){ 

		 driver.findElement(By.id("pass")).sendKeys(Keys.RETURN);   
		 }  
	    	 

	 @Test(priority=7)
		 public void VerifyUsername(){       
	   		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("._606w")).click();
		
		 String url = driver.getCurrentUrl(); 
		 String[] profile = url.split("/");
		 String name = profile[3];
		 
			 try{
			 Assert.assertEquals(name,USERNAME);
			 System.out.println("Username Verified");
			 JOptionPane.showMessageDialog(null,"Username Verified");
			 }
			 catch(AssertionError e) {
			 System.out.println("Username not Verified");
			 }
	 	}
	 
	 @AfterTest
		 public void QuitDriver() { 
			driver.quit();
		}


}

