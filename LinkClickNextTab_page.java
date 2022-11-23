package Pages;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkClickNextTab_page {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		driver.get("https://www.testingbaba.com/newdemo.html");
	
		Thread.sleep(1000);	
	 driver.findElement(By.xpath("//button[@data-target='#elements']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//a[text()='links']")).click();
	 
	 driver.findElement(By.xpath("//a[text()='Demo Page']")).click();;

	
	
	 //WebElement practice=driver.findElement(By.xpath("(//a[text()='Practice'])[1]"));
	 
	 
	
	 
	 Set<String> set=driver.getWindowHandles();
	 ArrayList<String> li=new ArrayList<String>(set);
	 Thread.sleep(1000);
	 driver.switchTo().window(li.get(1));
	 WebElement newwindow =driver.findElement(By.xpath("//button[text()='×']"));
	 System.out.println(newwindow);
	 String text=newwindow.getText();
	 System.out.println(text);
	 newwindow.click();
	// practice.click();
	 driver.close();
	 
	 driver.switchTo().window(li.get(0));
	 
	 
	}

}
