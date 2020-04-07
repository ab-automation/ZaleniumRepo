package com.zalenium.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	RemoteWebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setUpTest(String browser) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(browser.equals("chrome")) {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		URL url = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(url,capabilities);
		}
		else if (browser.equals("firefox")) {
			capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			URL url = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(url,capabilities);
		}
	}
	
	@BeforeMethod
	public void precondition() {
		driver.get("https://www.toolsqa.com/");
	}
}
