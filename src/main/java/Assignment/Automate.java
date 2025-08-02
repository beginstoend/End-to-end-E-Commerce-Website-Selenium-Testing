package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Automate {
	WebDriver driver;
	
	@BeforeMethod
	public void test1()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://systemefunnelservices.com/#/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("7972428355");
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("787878");
		driver.findElement(By.xpath("//button")).click();
		
		
		
		
		
		
	}
	
	@Test
	public void commodity() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[text()='Commodity']")).click();
		
		int k = 1;
		
		while(k<=5)
		{
			
			driver.findElement(By.xpath("//span[text()='START ']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[text()=' FUNNEL']")).click();
			k++;
		}
	}
	
	@Test(enabled = true)
	public void cashOut() throws InterruptedException
	{
		driver.findElement(By.xpath("//i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Cash out')]")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("787878");
		driver.findElement(By.xpath("//span[text()='verify']")).click();
		
		String p =driver.findElement(By.cssSelector(".text-h5")).getText();
		
		System.out.println(p);
	}
	
	

}
