package genericlibs;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	private static Workbook workbook;
	
	static {
		try {
			  workbook= WorkbookFactory.create(new FileInputStream(IAutoConstants.XL_PATH));
			}catch(Exception e) {
				e.printStackTrace();
				}
		
		
	}
	
	// Below all methods r static because 1 copy is enough ..so above v have useed static block to access
	//redundant data
	
	public static String getStringData(String sheetName,int rowNum,int cellNum) {
				
			return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		}
		
	public static double getNumericDoubleData(String sheetName,int rowNum,int cellNum) {
		
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	
	public static int getNumerIntData(String sheetName,int rowNum,int cellNum) {
		// by default it ll return double  cast to int 
	return (int) workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	
	public static boolean getBooleanData(String sheetName,int rowNum,int cellNum) {
		
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
	}
	
	public static LocalDateTime getLocalDate(String sheetName,int rowNum,int cellNum) {
		
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getLocalDateTimeCellValue();
	}
	
	
	public static String[][] getMultipledata(String sheetName){
		
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] arr=new String[rowCount-1][cellCount-1];
		//if u wann skip first row then take another var k ans start with 1 k=1 and k++
		for(int i=0,k=1;i<=rowCount-1;i++,k++ ) {
			for(int j=0;j<=cellCount-1;j++) {
				arr[k][j] =sheet.getRow(i).getCell(j).toString();
			}
		}
		return arr;
	}
	
	
	public static String getpropertyData(String Key) {
		
		Properties p=new Properties();
		try {
		FileInputStream fis=new FileInputStream(IAutoConstants.PROPERTIES_PATH);
		p.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return p.getProperty(Key);
	}
}
