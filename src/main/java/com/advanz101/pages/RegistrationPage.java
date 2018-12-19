package com.advanz101.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.advanz101.utills.ApplicationProperties;
import com.advanz101.utills.BasicUtill;

public class RegistrationPage extends BasicUtill {
	
    @FindBy(xpath = "(.//td[@class='mouseOut'])[2]")
    private WebElement registration_Lnk;
   @FindBy(xpath=".//input[@name='firstName']")
   private WebElement first_Name;
   @FindBy(xpath=".//input[@name='lastName']")
   private WebElement last_Name;
   @FindBy(xpath=".//input[@name='phone']")
   private WebElement phone;
   @FindBy(xpath=".//input[@name='userName']")
   private WebElement email;
   @FindBy(xpath=".//input[@name='address1']")
   private WebElement address_1;
   @FindBy(xpath=".//input[@name='address2']")
   private WebElement address_2;
   @FindBy(xpath=".//input[@name='city']")
   private WebElement city;
   @FindBy(xpath=".//input[@name='state']")
   private WebElement state;
   @FindBy(xpath=".//input[@name='postalCode']")
   private WebElement postal_Code;
   @FindBy(xpath=".//select[@name='country']")
   private WebElement country;
   //user information.
   @FindBy(xpath=".//input[@name='email']")
   private WebElement user_Name;
   @FindBy(xpath=".//input[@name='password']")
   private WebElement pass_Word;
   @FindBy(xpath=".//input[@name='confirmPassword']")
   private WebElement confirm_Pwd;
   @FindBy(xpath=".//input[@name='register']")
   private WebElement submit_Btn;
   
   
   public void openApps() {
		openBrowser(ApplicationProperties.getProperty("browser"));
		getDriver().get(ApplicationProperties.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
     public void user_Regitration() throws InterruptedException{
    	WebElement registration_Lnk = driver.findElement(By.xpath("(.//td[@class='mouseOut'])[2]"));
     	registration_Lnk.click();
    	WebElement first_Name= driver.findElement(By.xpath(".//input[@name='firstName']"));
    	 first_Name.sendKeys("Opesydra");
    	WebElement last_Name = driver.findElement(By.xpath(".//input[@name='lastName']"));
    	 last_Name.sendKeys("Uhet");
    	WebElement phone=driver.findElement(By.xpath(".//input[@name='phone']"));
    	 phone.sendKeys("1234567890");
    	WebElement email=driver.findElement(By.xpath(".//input[@name='userName']"));
    	 email.sendKeys("Esasgwat@tco.com");
    	WebElement address_1=driver.findElement(By.xpath(".//input[@name='address1']"));
    	 address_1.sendKeys("India 1245");
    	WebElement city=driver.findElement(By.xpath(".//input[@name='city']"));
    	 city.sendKeys("XYN");
    	 WebElement state = driver.findElement(By.xpath(".//input[@name='state']"));
    	 state.sendKeys("ABC");
    	 WebElement postalCode = driver.findElement(By.xpath(".//input[@name='postalCode']"));
    	 postalCode.sendKeys("123456");
    	WebElement country=driver.findElement(By.xpath(".//select[@name='country']"));
    	 Select sel = new Select(country);
    	 sel.selectByValue("92");
    	 WebElement user_Name=driver.findElement(By.xpath(".//input[@name='email']"));
    	 user_Name.sendKeys(ApplicationProperties.getProperty("Username"));
    	 Thread.sleep(2000);
    	 WebElement pass_Word=driver.findElement(By.xpath(".//input[@name='password']"));
    	 pass_Word.sendKeys(ApplicationProperties.getProperty("Password"));
    	 WebElement confirm_Pwd=driver.findElement(By.xpath(".//input[@name='confirmPassword']"));
    	 confirm_Pwd.sendKeys(ApplicationProperties.getProperty("Password"));
    	 WebElement submit_btn = driver.findElement(By.xpath(".//input[@name='register']"));
    	 submit_btn.click(); 
     }
     
	public void user_Login() {
    try {
    	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement sign_In = driver.findElement(By.xpath(".//a[text()=' sign-in ']"));
		sign_In.click();
		WebElement u_Name=driver.findElement(By.xpath(".//input[@name='userName']"));
		 u_Name.sendKeys(ApplicationProperties.getProperty("Username"));
		WebElement p_Word= driver.findElement(By.xpath(".//input[@name='password']"));
		p_Word.sendKeys(ApplicationProperties.getProperty("Password"));
		WebElement submit = driver.findElement(By.xpath(".//input[@name='login']"));
		submit.click();
		Thread.sleep(4000);
		WebElement flight = driver.findElement(By.xpath(".//a[text()='Flights']"));
		flight.click();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     }
}
