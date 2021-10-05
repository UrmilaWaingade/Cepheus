package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import genericlibs.WebActionUtil;

public class BasePage {

	public WebDriver driver;
	public WebActionUtil webactionutil;
	
	public BasePage(WebDriver driver,WebActionUtil webactionutil) {
		this.driver=driver;
		this.webactionutil=webactionutil;
		PageFactory.initElements(driver, this);
	}
	
}
