package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import applicationutility.Applicationutility;
import baselibrary.BaseLibrary;
import excelutility.ExcelUtillity;
public class TestingbabaWEBTABLE_PAGE extends BaseLibrary{
public TestingbabaWEBTABLE_PAGE() {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//*[@data-target='#elements']")
private WebElement elements;
@FindBy(xpath = "//a[text()='web tables']")
private WebElement webtable;

@FindBy(xpath = "//iframe[@src=\"Webtable.html\"]")
private WebElement webtableframe;
@FindBy(xpath = "//input[@pattern=\"^[a-zA-Z][\\sa-zA-Z]{2,32}\"]")
private WebElement name;
@FindBy(xpath = "//input[@pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\"]")
private WebElement email;
@FindBy(xpath = "//button[text()='Save']")
private WebElement savebtn;

//@FindBy(xpath = "//*[@class='table table-bordered data-table']//following::tr/td[3]")
//private List<WebElement> editlist;

@FindBy(xpath = "//button[text()='Edit']")
private List<WebElement> edit;
@FindBy(xpath = "//input[@name='edit_name']")
private WebElement editname;
@FindBy(xpath = "//input[@name=\"edit_email\"]")
private WebElement editemail;
@FindBy(xpath = "//button[text()='Update']")
private WebElement update;

    public void clickonelement()
    {
		WebDriverWait wait =new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(	elements)).click();
	}
    public void clickonwebtable()
    {
    	Applicationutility.clickme(webtable);
    } 

 //String path=System.getProperty("user.dir")+"/textdata/webtable.xlsx";
String path="C:\\Users\\s10000116\\eclipse-workspace\\Maven.Project_Practices\\textdata\\webtable.xlsx";
    public void savedata()
    {
    	driver.switchTo().frame(webtableframe);
    	for(int i=0;i<=5;i++)
    	{
    	name.sendKeys(ExcelUtillity.getReaddata1(path, 0, i, 0));
    	email.sendKeys(ExcelUtillity.getReaddata1(path,0, i, 1));
        Applicationutility.clickme(savebtn);	
        }
    }	
  public void updateddata()
  {
  int i=1;
  for(WebElement dd:edit)
  {
	dd.click();
	editname.clear();
	editname.sendKeys(ExcelUtillity.getReaddata1(path, 0, i, 2));
	editemail.clear();
	editemail.sendKeys(ExcelUtillity.getReaddata1(path, 0, i, 3));
	update.click();
	i++;
  }
 }


  
public void getvalidation()
{

	ArrayList<String> actual=new ArrayList<String>();
	
	 for(int k=1;k<actual.size()-1;k++)
	 {
		 actual.add(ExcelUtillity.getReaddata1(path, 0, k, 0));
	 }
	          
    List<WebElement>exli=driver.findElements(By.xpath("//*[@class='table table-bordered data-table']/thead/tr/following::tr/td[1]"));
	ArrayList<String> expected=new ArrayList<String>();
			for(int i=1;i<expected.size()-1;i++)
			{
				String data=exli.get(i).getText();
				System.out.println("mathch name  " +data);
				expected.add(data);    
			}	       		
			
			
////******************BY HARD ASSERT*********************//////
			for(int k=1; k<actual.size()-1; k++)
			{
			Assert.assertEquals(expected.get(k), actual.get(k));
			}

//////******************BY SOFT ASSERT*********************//////
//	SoftAssert aassert=new SoftAssert();		
//			for(int k=1; k<actual.size()-1; k++)
//			{
//				aassert.assertEquals(expected.get(k), actual.get(k));
//			}
//			aassert.assertAll();
}

 

}