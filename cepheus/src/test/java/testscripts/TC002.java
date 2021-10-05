package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibs.ExcelLibrary;
import pom.SkillraryDemoApp;
import pom.SkillraryLoginPage;
import pom.TestingPage;

public class TC002 extends BaseTest{

	
		@Test(description="To verify facebook login page should display")
		public void testCase2(){
			SkillraryLoginPage lp = new SkillraryLoginPage(driver, webactionutil);
			//lp.addCourse("skillrary demo App");
			String sheetName = "Tabelle1";
			String category=ExcelLibrary.getStringData(sheetName, 1, 2);
			lp.addCourse("skillrary demo App").SelectCategory(category).testing();
			//SkillraryDemoApp sda = new SkillraryDemoApp(driver, webactionutil);
			//sda.SelectCategory("Testing");
			
//			TestingPage stp=new TestingPage(driver, webactionutil);
//			stp.testing();
			
			Assert.assertEquals(driver.getTitle(), "Facebook – Anmelden oder Registrieren");
		}
}
