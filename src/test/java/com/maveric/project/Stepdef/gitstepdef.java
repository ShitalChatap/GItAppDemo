package com.maveric.project.Stepdef;

import java.util.Map;

//import java.util.Map;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.maveric.project.Factory;
import com.maveric.project.DataBean.UserBean;
import com.maveric.project.pageBean.LoginPageBean;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import io.cucumber.java.Scenario;

public class gitstepdef {

	private LoginPageBean pageBean;

	private WebDriver driver;

	
//	@Before
//	public static void beforeAll() {
//		System.out.println("  Before All ");
//	}
	
	@Before
	public void setUpEnv() 
	
	{
		System.out.println("Before  ");
		driver = Factory.getdriver();
		pageBean = PageFactory.initElements(driver, LoginPageBean.class);
	}
	
	@BeforeStep 
	public void beforeEachStep()
	{
		System.out.println(" ----> beforeEachStep ");
	}

	@Given("User is on github loging page")
	public void user_is_on_github_loging_page()
	{
		driver.get("https://github.com/login");
	}

	@DataTableType
	public UserBean userBeanData(Map<String, String> inputData)
	{
		UserBean bean = new UserBean();
		bean.setUserName(inputData.get("userName"));
		bean.setpassword(inputData.get("password"));
		return bean;
	}

	@When("User enter wrong credentials")
	public void user_enter_wrong_credentials(UserBean bean) 
	{
		pageBean.setUsername(bean.getuserName());
		pageBean.setPassword(bean.getPassword());
		pageBean.signIn();
		String expectedErrorMsg = "Incorrect username or password.";
		String actualErrorMsg = pageBean.getErrorMessage();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@When("click on submit")
	public void click_on_submit() 
	{

	}

	@Then("{string} message should display")
	public void message_should_display(String string) 
	{

	}

	@When("User enter valid credentials")
	public void user_enter_valid_credentials(UserBean bean) 
	{
		
		//Assert.fail();

	}

	@Then("user able tpo see home page of corresponding github account")
	public void user_able_tpo_see_home_page_of_corresponding_github_account() 
	{
			
	}
	
	@After
	public void tearDownEnv(Scenario scenario) 
	{
		if(scenario.isFailed()) 
		{
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte [] screenShot= takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", "errorScreen");
		}
		driver.quit();
	}
	
//	@After
//	public  static void afterAll() {
//		System.out.println("  After All");
//	}

}
