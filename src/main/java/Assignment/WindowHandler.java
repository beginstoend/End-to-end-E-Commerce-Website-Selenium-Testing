package Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class WindowHandler {
	WebDriver driver;
	
@BeforeMethod
@Parameters("browser")
public void InitializeChrome(String s)
{
	if(s.equals("chrome"))
	{
		driver = new ChromeDriver();

	}
	
	if(s.equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
	
	if(s.equals("edge"))
	{
		driver = new EdgeDriver();
	}
	
	driver.get("https://the-internet.herokuapp.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@AfterMethod
public void closeDriver() throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File tar = new File("E:\\Screens\\testCase"+Math.random()+".png");
	org.openqa.selenium.io.FileHandler.copy(source, tar);
	driver.quit();
}
@Test (enabled = true)
public void windowHandler()
{
	driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
	driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it = window.iterator();
	String parentWindow = it.next();
	String childWindow = it.next();
	
	driver.switchTo().window(childWindow);
	WebElement child = driver.findElement(By.xpath("//h3"));
	System.out.println(child.getText());
	
	driver.switchTo().window(parentWindow);
	WebElement parent = driver.findElement(By.xpath("//h3"));
	System.out.println(parent.getText());
	
	
}

@Test (enabled = true)
public void checkBox()
{
	driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
	boolean check =  driver.findElement(By.xpath("//input[1]")).isSelected();
	System.out.println(check);
	driver.findElement(By.xpath("//input[1]")).click();
	boolean check2 =  driver.findElement(By.xpath("//input[1]")).isSelected();

	System.out.println(check2);

}

@Test (enabled = false)
public void actionsContextClick()
{
	driver.findElement(By.xpath("//a[text()='Context Menu']")).click();
	Actions a = new Actions(driver);
	a.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
	String p = driver.switchTo().alert().getText();
	System.out.println(p);

	
}

@Test (enabled = true)
public void dragAndDrop()
{
	driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
	Actions a = new Actions(driver);
	WebElement source = driver.findElement(By.id("column-a"));
	WebElement tar = driver.findElement(By.id("column-b"));

   a.dragAndDrop(source, tar).build().perform();

}

@Test (enabled = true)
public void staticDropdown() throws InterruptedException
{
	driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
	WebElement r = driver.findElement(By.id("dropdown"));

	Select s = new Select(r);
	//r.click();
	s.selectByContainsVisibleText("Option 1");
	Thread.sleep(3000);

}

@Test (enabled = false)
public void get()
{
	List<WebElement> r = driver.findElements(By.id("dropdown"));
	for(WebElement p : r)
	{
		p.getText();
	}
}





}
