package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	
	public WebDriver driver;
	public LoginPage lp;
	@Given("User launch Chrome Browser")
	public void user_launch_Chrome_Browser() {
	    System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Cucumber_2\\nopCommerceV001_Cucumber\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	    lp = new LoginPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.manage().window().maximize();
	    driver.get(url);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_Email_as_and_password_as(String email, String password) {
	    lp.setUsername(email);
	    lp.setPassword(password);
	}

	@When("Clicks on Login")
	public void clicks_on_Login() {
	    lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String exp_title) {
	   if (driver.getPageSource().contains("Login was unsuccessful.")) {
		   driver.close();
		   Assert.assertTrue(false);
	   }else {
		   Assert.assertEquals(exp_title, driver.getTitle());
	   }
	   
	}

	@When("User clicks logout")
	public void user_clicks_logout() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(5000);
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}
	
	//Customer feature step definitions
	

	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
	    addCust = new AddCustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User clicks on Customer Menu")
	public void user_clicks_on_Customer_Menu() throws InterruptedException {
	    addCust.clickOnCustomersMenu();
	}

	@When("clicks on Customer Menu Item")
	public void clicks_on_Customer_Menu_Item() throws InterruptedException {
	    Thread.sleep(3000);
		addCust.clickOnCustomersMenuItems();
	}

	@When("Clicks on Add new button")
	public void clicks_on_Add_new_button() {
	    addCust.clickOnAddNew();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	   Thread.sleep(2000);
	   Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    String email =  randomString()+"@gmail.com";
	    addCust.setEmail(email);
	    addCust.setPassword("test123");
	    addCust.setFirstName("Shubham");
	    addCust.setLastName("Amale");
	    addCust.setGender("Male");
	    addCust.setDob("05/06/1996");
	    //Registered  - default
	    //Customer cannot be in both 'Guest' and 'Registered'
	    //Add customer to 'Guest'
	    addCust.setCustomerRoles("Guests");
	    Thread.sleep(3000);
	    
	    addCust.setManagerOfVendor("Vendor 2");
	    addCust.setAdminContent("This is for testing.........");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
	    addCust.clickOnSave();
	    Thread.sleep(3000);
	    
	    }

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}

	//Finding existing customer - Scenario 2
	
	@When("Enter cutomer EmailId")
	public void enter_cutomer_EmailId() {
	   searchCust = new SearchCustomerPage(driver);
	   searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Searh button")
	public void click_on_Searh_button() throws InterruptedException {
	   searchCust.clickSearch();
	   Thread.sleep(3000);
	}

	@Then("User should found email in the searched table")
	public void user_should_found_email_in_the_searched_table() {
	    boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true, status);
	}

  //search Customer by FirstName and LastName - Scenario -3
	
	@When("Enter cutomer FirstName")
	public void enter_cutomer_FirstName() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}

	@When("Enter cutomer LastName")
	public void enter_cutomer_LastName() {
	    searchCust.setLastName("Terces");
	}

	@Then("User should found Name in the searched table")
	public void user_should_found_Name_in_the_searched_table() {
	    boolean status = searchCust.searchCustomerByName("Victoria Terces");
	    Assert.assertEquals(true, status);
	}


}
