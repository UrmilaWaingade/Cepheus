package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibs.ExcelLibrary;
import pom.SeleniumTrainingPage;
import pom.SkillraryDemoApp;
import pom.SkillraryLoginPage;

public class TC001 extends BaseTest{

	@Test(description="To verify item is added to cart")
	public void test() {
//		  SkillraryLoginPage lp = new SkillraryLoginPage(driver, webactionutil);
//		lp.addCourse("skillrary demo App");
	//when v use landing page in pom no need to create object of every class ,action method
//		itself ll take care
		String sheetName = "Tabelle1";
		String gears=ExcelLibrary.getStringData(sheetName, 1, 0);
		//String category=ExcelLibrary.getStringData(sheetName, 1, 2);
		String	course=ExcelLibrary.getStringData(sheetName,1,1);
		
		SkillraryLoginPage lp = new SkillraryLoginPage(driver, webactionutil);
	lp.addCourse(gears).skillraryDemoApp(course).seleniumTraining("add to cart");
		
	
	//webactionutil.switchTo2ndWindow(driver);
		//SkillraryDemoApp da=new SkillraryDemoApp(driver,webactionutil);
		
		//da.skillraryDemoApp("selenium training").seleniumTraining("add to cart");
		
		//SeleniumTrainingPage stp=new SeleniumTrainingPage(driver,webactionutil);
		
		//stp.seleniumTraining("add to cart");
		Assert.assertEquals(driver.getTitle(),"SkillRary Courses");
	} 
}
