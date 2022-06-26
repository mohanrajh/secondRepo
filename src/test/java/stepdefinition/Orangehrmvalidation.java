package stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Orangehrmvalidation {
	WebDriver driver;
	@Given("I load the url {string}")
	public void i_load_the_url(String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		
	}

	@Then("I enter username as {string}")
	public void i_enter_username_as(String name) {
		driver.findElement(By.name("txtUsername")).sendKeys(name);
	}

	@Then("I enter password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.name("txtPassword")).sendKeys(password);

	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		driver.findElement(By.name("Submit")).click();
	}

	@Then("I should land on the dashboard page")
	public void i_should_land_on_the_dashboard_page() {
		String page=driver.getCurrentUrl();
		if(!page.contains("dashboard")) {
			Assert.assertTrue(false);
		}
//		else {
//			Assert.assertTrue(false);
//		}
	}

//	@Then("I validate the style part of quic launch {string}")
//	public void i_validate_the_style_part_of_quic_launch(String fontweight) 
//	{
//		List<WebElement> cssvalue=driver.findElements(By.xpath("//span[@class='quickLinkText']"));
//		//.getCssValue(fontweight);
//		for(int i=0;i<cssvalue.size();i++) {
//			String value=cssvalue.get(i).getCssValue(fontweight);
//			System.out.println(value);
//			if(!value.equals("700")) {
//				Assert.assertTrue("style not match", false);		
//					}
//
//		}


//}
	
	@Then("I validate the style part of the element")
	public void stylevalidation(DataTable value) {
		List<List<String>>listofdata= value.asLists();
//		listofdata.get(1).get(0);
//		listofdata.get(1).get(1);
		int row=(value.asLists().size());
		int col=(listofdata.get(1).size());
		for(int i=1;i<row;i++) {
			
			for(int j=0;j<col;j++) {
				
				String data=listofdata.get(i).get(j);
				System.out.println(data);
			 
				String style=driver.findElement(By.xpath(listofdata.get(i).get(1))).getCssValue(listofdata.get(i).get(0));
				System.out.println(style);
				if(!style.equals("700")) {
				Assert.assertTrue("style not match", false);		
					}	

			}
		
	}
}
}
