package com.advanz101.utills;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class BasicUtill {
	public BasicUtill() {

	}

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void openBrowser(String browser) {


		 if (browser.equalsIgnoreCase("chrome")) {

			ChromeDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		 
		else if (browser.equalsIgnoreCase("edge")) {
			EdgeDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		}
		else if (browser.equalsIgnoreCase("firefox")) {

			FirefoxDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			InternetExplorerDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}  else {
			System.out.println("Unable to create browser intance");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void pageToLoadImplicitWait(int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);

	}

	public static void waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static Wait<WebDriver> waitABit(int time) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofMillis(5)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return wait;
	}
public static void elementToBeClickeble(int time, WebElement element) {
	WebDriverWait waits = new WebDriverWait(driver, time);
	waits.until(ExpectedConditions.elementToBeClickable(element));
}
	public static WebElement getElement(String locatorType, String webElementNamePropfile) {
		WebElement element = null;
		final long startTime = System.currentTimeMillis();
		boolean found = false;
		while ((System.currentTimeMillis() - startTime) < 20000)
			try {
				if (locatorType.equals("id")) {
					element = driver.findElement(By.id(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("name")) {
					element = driver.findElement(By.name(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("xpath")) {
					element = driver.findElement(By.xpath(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("className")) {
					element = driver
							.findElement(By.className(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("tagName")) {
					element = driver.findElement(By.tagName(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("linkText")) {
					element = driver
							.findElement(By.linkText(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("partialLinkText")) {
					element = driver
							.findElement(By.partialLinkText(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else if (locatorType.equals("cssSelector")) {
					element = driver
							.findElement(By.cssSelector(ApplicationProperties.getProperty(webElementNamePropfile)));
					found = true;
					break;
				} else {
					System.out.println("Locator type does not match");
				}
			} catch (Exception e) {
				System.out.println(webElementNamePropfile + " not found " + e.getMessage());
			}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			System.out.println("Successfully found the element: " + webElementNamePropfile + " - waited for: "
					+ totalTime + " ms");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("COULD NOT FIND THE ELEMENT: " + webElementNamePropfile + " - after waiting for: "
					+ totalTime + " ms");

		}

		return element;
	}

	public static void tearDown() {
		if (driver != null)
			driver.quit();

	}
	public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)driver);

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

                File DestFile=new File(fileWithPath);

                FileUtils.copyFile(SrcFile, DestFile);

    }
}
