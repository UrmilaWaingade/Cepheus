package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;

public class SkillraryDemoApp extends BasePage{

//	@FindBy(xpath="//a[text()='COURSE']")
//	private WebElement courseOption;
	
	@FindBy(id="course")
	private WebElement courseOption;
	
	
	@FindBy(xpath="//div[@class='dropdown-content']//a")
	private List<WebElement> courseDropDownList;
	
	@FindBy(xpath="//select[@class='chosen-select']")
	private WebElement selectCatgory;
	
	
	
	public WebElement getSelectCatgory() {
		return selectCatgory;
	}

	public SkillraryDemoApp(WebDriver driver, WebActionUtil webactionutil) {
		super(driver,webactionutil);
	}

	public WebElement getCourseOption() {
		return courseOption;
	}

		
	public List<WebElement> getCourseDropDownList() {
		return courseDropDownList;
	}

	public void courseOptions(String menuName) {
		
		for(WebElement ele:courseDropDownList) {
			if(ele.getText().equalsIgnoreCase(menuName)) {
				webactionutil.click(ele);
				break;//if nt specified v ll get staleElementReferenceException
			}
			
		}
	}
	
		public SeleniumTrainingPage skillraryDemoApp(String menuName) {
			
			webactionutil.switchToWindow("https://demoapp.skillrary.com/index.php");
			webactionutil.moveToElement(courseOption);
			
			courseOptions(menuName);

		
			return new SeleniumTrainingPage(driver,webactionutil);

		}
		
		public TestingPage SelectCategory(String selectOption) {
			webactionutil.switchToWindow("https://demoapp.skillrary.com/index.php");
			webactionutil.selectByVisibleText(selectCatgory,selectOption);
			return new TestingPage(driver,webactionutil);
		}
	
}
