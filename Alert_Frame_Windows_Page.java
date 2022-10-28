package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Alert_Frame_Windows_Page {
	
	
	@FindBy(xpath = "//span[text()='Browser Windows']")
	private WebElement browserwindow;

	@FindBy(xpath = "//button[text()='New Tab']")
	private WebElement newmsgwind;


    public void chliconchildwindow()
    {
    	browserwindow.click();
    
    }
		
}
