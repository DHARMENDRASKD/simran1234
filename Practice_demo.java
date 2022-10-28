package Pages;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Practice_demo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\s10000116\\eclipse-workspace\\Maven.Project_Practices\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        // Opening all the child window
//        driver.findElement(By.id("windowButton")).click();
//        driver.findElement(By.id("messageWindowButton")).click();
        
       Thread.sleep(500);
        driver.findElement(By.id("tabButton")).click();
        driver.switchTo().defaultContent();
       
        driver.findElement(By.xpath("//button[text()='New Window']")).click();
        driver.switchTo().defaultContent();
  
        driver.findElement(By.xpath("//button[text()='New Window Message']")).click();
        driver.switchTo().defaultContent();
        
        
      //for 1 winndow
      Thread.sleep(500);
      Set<String> set1=driver.getWindowHandles();
      ArrayList<String>li1=new ArrayList<String>(set1);
      driver.switchTo().window(li1.get(1));
      String data1=driver.findElement(By.xpath("//*[text()='This is a sample page']")).getText();
      System.out.println(data1);
      Thread.sleep(500);
      driver.close();


        
        //for 2 winndow
        Thread.sleep(500);
        Set<String> set2=driver.getWindowHandles();
        ArrayList<String>li2=new ArrayList<String>(set2);
        driver.switchTo().window(li2.get(2));
        String data2=driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(data2);
        Thread.sleep(500);
        driver.close();

        
      //for 3 winndow
        Thread.sleep(500);
        Set<String> set3=driver.getWindowHandles();
        ArrayList<String>li3=new ArrayList<String>(set2);
        driver.switchTo().window(li3.get(3));
        String data3=driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")).getText();
        System.out.println(data3);
        Thread.sleep(500);
        driver.close();
              
        Thread.sleep(500);
        Set<String> set0=driver.getWindowHandles();
        ArrayList<String>li0=new ArrayList<String>(set0);
        driver.switchTo().window(li0.get(0)); 
     
        }
    }