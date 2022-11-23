package Pages;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.BaseLibrary;

public class Sotted_Data_Testingbaba_page extends BaseLibrary{

	public Sotted_Data_Testingbaba_page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@data-target=\"#interations\"]")
	private WebElement integration;
	
	@FindBy(xpath = "//*[text()='sortable']")
	private WebElement sortable;
	
	@FindBy(xpath = "//*[text()='Sort']")
	private WebElement sortbtn;
	
	@FindBy(xpath = "//*[@id=\"myTable\"]/tbody/tr/td[1]")
	private List<WebElement> sorted;
 
	
	public void actiondata( ) throws InterruptedException
	{
		Thread.sleep(1000);
		integration.click();
		
		sortable.click();
		Applicationutility.clickme(sortbtn);
		
	}
	public void verydata()
	{		
//		List<WebElement> sorted= driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[1]"));
		TreeSet<String> set=new TreeSet<String>();
		
		for(WebElement dd:sorted)
		{
//			String data=dd.getText();
//			set.add(data);
			set.add(dd.getText());
		}
		
	
		
		for(WebElement dd1:sorted)
		{
			for(String dd2:set)
			{
				if((dd1).getText().equals(dd2))
				{
					System.out.println("match");
					set.remove(dd2);
					break;
				}
			}
		}
		
		
	}
	
}
