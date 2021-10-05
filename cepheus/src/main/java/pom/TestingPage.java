package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;

public class TestingPage extends BasePage{
	@FindBy(xpath="//img[@id='Cucumber']")
	private WebElement srcDrag;
	
	@FindBy(id="mycart")
	private WebElement destDrag;

	@FindBy(xpath="//a[@href='https://bit.ly/FSKILLRARY' and not (@class)]")
	private WebElement facebookIcon;

	@FindBy(xpath="//button[contains(@class,'likeButton ')]")
	private WebElement fbLikeBtn;
	
	@FindBy(xpath="//button[@data-cookiebanner='accept_button']")
	private WebElement acceptCookie;
	
	
	
	public WebElement getAcceptCookie() {
		return acceptCookie;
	}


	public WebElement getFbLikeBtn() {
		return fbLikeBtn;
	}


	public WebElement getSrcDrag() {
		return srcDrag;
	}


	public WebElement getDestDrag() {
		return destDrag;
	}


	public WebElement getFacebookIcon() {
		return facebookIcon;
	}


	public TestingPage(WebDriver driver, WebActionUtil webactionutil) {
		super(driver, webactionutil);
		// TODO Auto-generated constructor stub
	}
	
	
		public void	testing(){
			webactionutil.switchToWindow("https://demoapp.skillrary.com/category.php?category=testing");
			
			webactionutil.clickAndHold(srcDrag, destDrag);
			webactionutil.scrollToBottom(0, 400);
			webactionutil.click(facebookIcon);
			webactionutil.jsClick(fbLikeBtn);
			webactionutil.click(acceptCookie);
			}

}
