package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibs.ExcelLibrary;
import genericlibs.Futil;
import pom.TwitterPage;

public class TC003 extends BaseTest{
	
	@Test(description="To verify twitter login page should display")
	public void testCase3() {
	TwitterPage tp=new TwitterPage(driver, webactionutil);
	String sheetName = "Tabelle1";
	String enterData=ExcelLibrary.getStringData(sheetName, 1, 3);
	tp.twitter(enterData);
	
	String expectedUrl="https://twitter.com/intent/tweet?url=https://www.skillrary.com/988816010";
	Futil.sleepInSeconds(3);
	Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
	}
	
}
