package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.WebActionUtil;

public class SkillraryLoginPage extends BasePage{

	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsOption;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu gear_menu']//li")
	private List<WebElement> gearDropdownList;


	public WebElement getGearsOption() {
		return gearsOption;
	}

	
	public List<WebElement> getGearDropdownList() {
		return gearDropdownList;
	}

	public SkillraryLoginPage(WebDriver driver,WebActionUtil webactionutil){
		super(driver,webactionutil);
	}

	public void gearDropdown(String optionName) {
		
		for(WebElement ele:gearDropdownList) {
			
			if(ele.getText().equalsIgnoreCase(optionName)) {
				
				webactionutil.click(ele);
				break;
			}
		}
	}
	 public SkillraryDemoApp addCourse(String optionName) {
		 
		 //gearsOption.click();
		 webactionutil.click(gearsOption);
		 gearDropdown(optionName);
		 
		return new SkillraryDemoApp(driver,webactionutil);
		 		 
	 }
	
	
}
