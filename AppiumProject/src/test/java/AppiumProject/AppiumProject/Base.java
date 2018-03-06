package AppiumProject.AppiumProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	private static AndroidDriver<MobileElement> driver;  

	

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		//File classpathRoot = new File(System.getProperty("user.dir"));
		//File appDir = new File(classpathRoot, "/Apps/Amazon/");
		//File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");	
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		desiredCapabilities.setCapability("deviceName", "Pixel4");
		desiredCapabilities.setCapability("platformVersion", "6.0");
		desiredCapabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		//capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("Driver is running");
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testCases() throws InterruptedException {
		String myname = "Smriti";
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.xpath("//textfield[1]")).sendKeys(myname);
		driver.findElement(By.name("Save")).click();
		Thread.sleep(5000);
		// write all your tests here
	}
}
