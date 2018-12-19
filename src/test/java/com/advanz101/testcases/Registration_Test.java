package com.advanz101.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.advanz101.pages.RegistrationPage;
import com.advanz101.utills.BasicUtill;

public class Registration_Test extends BasicUtill {

	/*
	 * @BeforeTest public void openBrowserAndApps() {
	 * 
	 * 
	 * }
	 */
	@Test
	public void registration() throws InterruptedException {
		RegistrationPage registration_page = PageFactory.initElements(driver, RegistrationPage.class);
		registration_page.openApps();
		registration_page.user_Regitration();
		registration_page.user_Login();
		String Expected = driver.findElement(By.xpath("(.//font[@face='ARIAL, HELVETICA'])[1]")).getText();
		Assert.assertTrue(Expected.contains("Flight"), "Flight Details section not displayed");
		System.out.println("Flight Details section successfully displayed");

	}
}
