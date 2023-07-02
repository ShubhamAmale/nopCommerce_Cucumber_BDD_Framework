package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	By lnkCustomers_menu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[5]");
	By lnkCustomers_menuitem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
	By btnAddnew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By txtEmail = By.id("Email");
	By txtPassword = By.id("Password");
	By txtcustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By lstitemAdministrators = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By lstitemRegistered = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	By lstitemGuests = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By lstitemVendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[6]");
	By drpmgrOfVendor = By.xpath("//*[@id=\"VendorId\"]");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	By txtFirstName = By.id("FirstName");
	By txtLastName = By.id("LastName");
	By txtDob = By.id("DateOfBirth");
	By txtCompanyName = By.id("Company");
	By txtAdminContent = By.id("AdminComment");
	By btnSave = By.name("save");
	
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	
	public void clickOnCustomersMenu() {
			ldriver.findElement(By.xpath("//*[@id=\"nopSideBarPusher\"]/i")).click();
			ldriver.findElement(lnkCustomers_menu).click();
		
	}
	
	public void clickOnCustomersMenuItems() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddNew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException {
		/* if(!role.equals("Vendors"))
		 {
			 ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[6]"));
		 }
		 */
		ldriver.findElement(By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/ul/li/span[2]")).click();
		 ldriver.findElement(txtcustomerRoles).click();
		 WebElement listitem;
		 Thread.sleep(3000);
		 
		 if(role.equals("Administrators")) {
			 listitem = ldriver.findElement(lstitemAdministrators);
		 }else if(role.equals("Guests")){
		 
		 listitem = ldriver.findElement(lstitemGuests); 		 
	}else if(role.equals("Vendors")) {
		listitem = ldriver.findElement(lstitemVendors);
	}else if (role.equals("Registered")) {
		listitem = ldriver.findElement(lstitemRegistered);
	}else {
		listitem = ldriver.findElement(lstitemGuests);
	}
		 
	//listitem.click(); OR
	
	JavascriptExecutor js = (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click();", listitem);	
}
	
	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
	}
	
	
	public void setGender(String gender)
	{
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}else if(gender.equals("Female")) {
			ldriver.findElement(rdFemaleGender).click();
		}else {
			ldriver.findElement(rdMaleGender).click();
		}
	}
	
	public void setFirstName (String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName (String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setDob (String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName (String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent (String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
	
}
