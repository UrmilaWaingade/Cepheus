package genericlibs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebActionUtil {
	//initialized non static members in constructor  to access in methods v need to declare globaly
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	Actions actions;
	
//		constructor ;redundant code we have kept in constructor
		public  WebActionUtil(WebDriver driver,long ETO) {
			this.driver=driver;//if v write this no need to pass driver to methods..it takes from here
			wait=new WebDriverWait(driver,ETO);
			jse=(JavascriptExecutor)driver;
			actions=new Actions(driver);
			
			
		}
		
		// methods r non static so v go for constructor and consructor
//		is used to initialize non static data members
		public void enterData(WebElement target,String text) {
			wait.until(ExpectedConditions.visibilityOf(target));
			target.clear();
			target.sendKeys(text);
		}
		
		public void enterJsData(WebElement target,String text) {
			wait.until(ExpectedConditions.visibilityOf(target));
			
			jse.executeScript("arguments[0].value=arguments[1]",target,text);
			
		}
		
		public void jsClick(WebElement target) {
			wait.until(ExpectedConditions.visibilityOf(target));
			jse.executeScript("arguments[0].click()", target);
		}
		
		public void click(WebElement target) {
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(target));
				target.click();
			}catch(Exception e) {
				target.sendKeys(Keys.ENTER);
			}
		}
		
		public void scroll(int xpixels,int ypixels) {
			
			jse.executeScript("scrollBy(arguments[0],arguments[1])", xpixels,ypixels);
		}
		
		public void scrollToTop(int xpixels,int ypixels) {
			
			jse.executeScript("scrollTo(0,-document.body.scrollHeight)");
		}
		
		public void scrollToBottom(int xpixels,int ypixels) {
	
			jse.executeScript("scrollTo(0,document.body.scrollHeight)");
		}
		
		
		public void dragAndDrop(WebElement src,WebElement dest) {
			wait.until(ExpectedConditions.visibilityOf(dest));
			actions.dragAndDrop(src,dest).build().perform();
			
		}
		
		public void clickAndHold(WebElement src,WebElement dest) {
		
		actions.clickAndHold(src).perform();
		actions.dragAndDrop(src,dest).release().perform();
		//actions.moveToElement(src,300,dest).release().perform();
		}
		
		public void moveToElement(WebElement target) {
			//System.out.println(target);
			wait.until(ExpectedConditions.visibilityOf(target));
			actions.moveToElement(target).build().perform();
			
		}
		
		public void doubleClick(WebElement target) {
			wait.until(ExpectedConditions.elementToBeClickable(target));
			
			
			actions.doubleClick(target).perform();
			
			
		}
		
		public void contextClick(WebElement target) {
			
			actions.contextClick(target).perform();
			
		}
		
		public void isMultiple(WebElement target) {
			
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			if(s.isMultiple()){
				System.out.println("multi select");
			}else {
				System.out.println("single select");
			}
		}
		
		public void selectByVisibleText(WebElement target,String text) {
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.selectByVisibleText(text);
			
		}
		
		public void selectByIndex(WebElement target,int index) {
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.selectByIndex(index);
			
		}
		
		public void selectByValue(WebElement target,String value) {
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.selectByValue(value);
			
		}
		
		public void getFirstSelectedOption(WebElement target) {
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.getFirstSelectedOption().getText();
			
		}
		
		public void getAllSelectedOptions(WebElement target) {
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
		List<WebElement> allSelectedOptions=s.getAllSelectedOptions();
			
			for(WebElement ele:allSelectedOptions) {
				System.out.println(ele.getText());
			}
		}
		
		public void deselectByVisibleText(WebElement target,String text) {
			
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.deselectByVisibleText(text);
		}
		
		
		
		public void deselectByIndex(WebElement target,int index) {
			
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.deselectByIndex(index);
		}
		
		public void deselectByValue(WebElement target,String value) {
			
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.deselectByValue(value);
		}
		
		public void deselectAll(WebElement target) {
			
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			s.deselectAll();
		}
		
		public void getOptions(WebElement target,String options) {
			
			wait.until(ExpectedConditions.visibilityOf(target));
			Select s=new Select(target);
			List<WebElement> allOptions=s.getOptions();
			for(WebElement ele:allOptions) {
				if(ele.getText().equalsIgnoreCase(options)) {
					System.out.println("All options r correct");
				}else {
					System.out.println("in correct options ");
				}
			}
		}
		
		
		public void closeAllBrowserWindow() {
			
		String	parentWinId=driver.getWindowHandle();
		
			Set<String> allWinIds=driver.getWindowHandles();
			allWinIds.remove(parentWinId);
			
			for(String win:allWinIds) {
				driver.switchTo().window(win);
				driver.close();
			}
			driver.switchTo().window(parentWinId);
		}
		
		
		public void switchToparentWindow() {
			
			List<String> allWinIds=new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(allWinIds.get(0));
			
			}
		
		//if u want to go particular window and perform operation
		public void switchToWindow(String url) {
			
			Set<String> allWinIds=driver.getWindowHandles();
			
			for(String win:allWinIds) {
				
				driver.switchTo().window(win);
				
				if(driver.getCurrentUrl().equals(url)) {
					
					break;
				}
			}
			
		}
		
		public void switchTo2ndWindow() {
			Set<String> allWinId=driver.getWindowHandles();
			List<String> allWinIdList= new ArrayList<String>(allWinId);
			String secondwid=allWinIdList.get(1);
			driver.switchTo().window(secondwid);
			System.out.println(driver.getCurrentUrl());
		}
		
		public void switchToFrame(String indexOrName) {
			try {
				int index=Integer.parseInt(indexOrName);
				driver.switchTo().frame(index);
			}catch(NumberFormatException e) {
				driver.switchTo().frame(indexOrName);
			}
			
		}
		
		public void switchToFrameTarget(WebElement target) {
				driver.switchTo().frame(target);
		}
		
		public void switchToOneFrame() {
			driver.switchTo().frame(0);
	}

		public void switchBackFromFrame() {
			driver.switchTo().defaultContent();
		}
		
		public void acceptAlert(String text) {
			
			wait.until(ExpectedConditions.alertIsPresent());
			
			try {
			Alert alert=driver.switchTo().alert();
						
				if(alert.getText().contains(text)) {
				
				alert.accept();
				}
			}catch(NoAlertPresentException e) {
				try {
					driver.switchTo().alert().accept();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
		
		
		public void cancelAlert(String text) {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			
				if(alert.getText().contains(text)) {
					alert.dismiss();
				}
			
		}
		
		public void verifyPage(String expectedTitle,String expectedUrl) {
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			wait.until(ExpectedConditions.urlContains(expectedUrl));
			
		}
		
		
		public void quitBrowser() {
			
			
			try {
				driver.quit();
			} catch(Exception e) {
				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_F4);
					
					robot.keyRelease(KeyEvent.VK_ALT);
					robot.keyRelease(KeyEvent.VK_F4);
				} catch(Exception e2) {
					
				}
				
			}
		}

		
}
