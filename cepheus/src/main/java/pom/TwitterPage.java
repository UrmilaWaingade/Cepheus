package pom;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.Futil;
import genericlibs.WebActionUtil;

public class TwitterPage extends BasePage{

	public TwitterPage(WebDriver driver, WebActionUtil webactionutil) {
		super(driver, webactionutil);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="q")
	private WebElement searchTxtBox;
	
	@FindBy(xpath="//a[text()=' Selenium']")
	private WebElement seleniumLink;
	

	@FindBy(xpath="//input[@value='go']")
	private WebElement srchBtn;
	
	@FindBy(xpath="//a[@class='close_cookies']")
	private WebElement closeBtn;
	
	
	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getVideobtn() {
		return videobtn;
	}

	public WebElement getTwitterLink() {
		return twitterLink;
	}

	@FindBy(xpath="//div[@class='banner_watch']")
	private WebElement videobtn;
	
	@FindBy(xpath="//a[@class='twitter']")
	private WebElement twitterLink;
	
//	@FindBy(xpath="//a[contains(@href,'https://twitter.com/intent/tweet?url=https://www.skillrary.com/')]")
//	private WebElement twitterLink;
	
	
	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getSeleniumLink() {
		return seleniumLink;
	}

	public WebElement getSrchBtn() {
		return srchBtn;
	}

	
	
		
	public void twitter(String text) {
		webactionutil.enterData(searchTxtBox, text);
		webactionutil.switchToWindow("https://www.skillrary.com/search?q=selenium");
		webactionutil.click(srchBtn);
		webactionutil.click(seleniumLink);
		//webactionutil.switchToOneFrame();
		if(closeBtn.isDisplayed()) {
			webactionutil.click(closeBtn);
		}else {

				webactionutil.jsClick(videobtn);
				
				webactionutil.jsClick(videobtn);
				
				
			}
		
		webactionutil.jsClick(videobtn);
	
		webactionutil.jsClick(videobtn);
		
		webactionutil.jsClick(twitterLink);
		
		webactionutil.switchToWindow("https://twitter.com/intent/tweet?url=https://www.skillrary.com/988816010");
	}
		
		//webactionutil.switchBackFromFrame();
		
}
