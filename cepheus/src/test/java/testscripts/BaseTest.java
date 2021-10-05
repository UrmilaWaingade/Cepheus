package testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericlibs.Futil;
import genericlibs.IAutoConstants;
import genericlibs.WebActionUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConstants{

	public WebDriver driver;
	public WebActionUtil webactionutil;
	
		@Parameters({"browserName","appUrl","implicit","Explicit"})
		
		@BeforeClass(alwaysRun=true)
		public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
				@Optional(DEFAULT_URL)String appUrl,
				@Optional(ITO)String implicit,
				@Optional(ETO)String Explicit) {
			
		//System.out.println(browserName);
			if(browserName.equalsIgnoreCase("chrome"))	{	
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(appUrl);
				driver.manage().timeouts().implicitlyWait(Long.parseLong(implicit),TimeUnit.SECONDS);
				webactionutil = new WebActionUtil(driver, Long.parseLong(Explicit));
			
			}else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(appUrl);
				driver.manage().timeouts().implicitlyWait(Long.parseLong(implicit),TimeUnit.SECONDS);
				webactionutil = new WebActionUtil(driver, Long.parseLong(Explicit));
			}else {
				Assert.fail("only 2 browsers chrome and firefox are supported");
			}
		}
		
		
		@AfterMethod(alwaysRun=true)
		public void logout(ITestResult result) {
			if(result.getStatus()==ITestResult.FAILURE) {
				Reporter.log(Futil.getSnapshot(driver,result.getName()),true);
			}
		}
		
		@AfterClass(alwaysRun=true)
		public void closeApp() {
			
			webactionutil.quitBrowser();
		}
}
