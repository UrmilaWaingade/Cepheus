package genericlibs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Futil {

	//this method has to return path of screenshot so v hav taken return type as string
	public static String getSnapshot(WebDriver driver,String testCaseName) {
		String timeStamp=LocalDateTime.now().toString().replace(":", "-");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(IAutoConstants.SCREENSHOT_PATH+testCaseName+timeStamp+".png");
		try {
		FileUtils.copyFile(tempFile, destFile);
		//return  destFile.getAbsolutePath();
		}catch(IOException e) {
			e.printStackTrace();
			// null is default value fr reference in java --method return type 
						//	is String so need to return something
		}
		return timeStamp;
		 
	}
	
	public static String getWebElementSnapshot(WebDriver driver,WebElement target) {
		String timeStamp=LocalDateTime.now().toString().replace(":", "-");
		
		File tempFile=target.getScreenshotAs(OutputType.FILE);
		File destFile=new File(IAutoConstants.SCREENSHOT_PATH);
		try {
		FileUtils.copyFile(tempFile, destFile);
		return  destFile.getAbsolutePath();
		}catch(IOException e) {
			e.printStackTrace();
			return null;// null is default value fr reference in java --method return type 
						//	is String so need to return something
		}
		 
	}
	
	public static void sleepInSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
