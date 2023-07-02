package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	WaitHelper waithelper;

public WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this); 
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement txtEmail;
	
	@FindBy(id = "SearchFirstName")
	WebElement txtFirstName;
	
	
	@FindBy(id = "SearchLastName")
	WebElement txtLastName;
	
	@FindBy(id = "SearchMonthOfBirth")
	WebElement txtMonOfBirth;
	
	@FindBy(id = "SearchDayOfBirth")
	WebElement txtDayOfBirth;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")
	WebElement removeCustRole;
	
	@FindBy(id = "search-customers")
	WebElement btnSearch;
	
	@FindBy(xpath ="//*[@id=\"customers-grid_wrapper\"]")
	WebElement table;
	
	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> tableRows;
	
	
	@FindBy(xpath = "//*[@id=\"customers-grid\"]/tbody/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		waithelper.WaitFOrElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		waithelper.WaitFOrElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		waithelper.WaitFOrElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void clickSearch() {
		btnSearch.click();
		waithelper.WaitFOrElement(btnSearch, 30);
	}
	
	public int getNoOfRows() {
		return (tableRows.size());
	}
	
	public int getNoOfColumns() {
		return (tableColumns.size());
	}
	
	
	public boolean searchCustomerByEmail(String email)
	{
		System.out.println(getNoOfRows());
		System.out.println(getNoOfColumns());
		
		boolean flag = false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailId = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag = true;
			}
		}
		
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		System.out.println(getNoOfRows());
		System.out.println(getNoOfColumns());
		
		boolean flag = false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(name);
			String names[] = name.split(" ");
			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag = true;
			}
		}
		
		return flag;
	}
	
	
	
	
	
	
	
	
	
}
