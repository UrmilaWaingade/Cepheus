package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.Futil;
import genericlibs.WebActionUtil;

public class SeleniumTrainingPage extends BasePage{

		@FindBy(id="add")
		private WebElement addBtn;
		
		@FindBy(xpath="//button[@ondblclick='addtocart()']")
		private WebElement addToCart;
		
		@FindBy(xpath="//a[@class='dropdown-toggle']")
		private WebElement cartIcon;
		

		public WebElement getCartIcon() {
			return cartIcon;
		}

		public SeleniumTrainingPage(WebDriver driver, WebActionUtil webactionutil) {
			super(driver,webactionutil);
		}

		public WebElement getAddBtn() {
			return addBtn;
		}

		public WebElement getAddToCart() {
			return addToCart;
		}
		
//		public boolean itemToCart(String item) {
//			if(cartIcon.isDisplayed()) {
//				return true;
//			}else {
//				return false;
//			}
//		}
		
	public	void seleniumTraining(String text) {
		webactionutil.switchToWindow("https://demoapp.skillrary.com/product.php?product=selenium-training");	
			webactionutil.doubleClick(addBtn);
			
			webactionutil.click(addToCart);
			Futil.sleepInSeconds(3);
			webactionutil.acceptAlert(text);
			
			//webactionutil.click(cartIcon);
			
		//	itemToCart(item);
		}
}
