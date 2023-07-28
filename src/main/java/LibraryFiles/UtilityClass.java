package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	// method created: to fetch ExcelSheet data_with_Rows_and_Columns:
	public static String getTestdata(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		
		FileInputStream file=new FileInputStream("D:\\Velocity\\Eclipse_workspace_2022_06\\SeleniumRevisionMaven1\\TestData\\PracticeWithDDF.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
		
	}
	
	//method created: to capture failed TC Screenshot in that specific folder:
	public static void captureSS(WebDriver d,int TCID) throws IOException {
		
		File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Velocity\\Eclipse_workspace_2022_06\\SeleniumRevisionMaven1\\FailedTCSS\\testCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
		
	}
	
	//method created for getting PropertyFile Data:
	public static String getPFData(String key) throws IOException {
		
		FileInputStream file=new FileInputStream("D:\\Velocity\\Eclipse_workspace_2022_06\\SeleniumRevisionMaven1\\PropertyFile.properties");
		
		Properties p=new Properties();		// use of Property Class
		p.load(file);						// to open PropertyFile
		
		String value = p.getProperty(key);	// our data is store in 'key-value' format so to fetch it we need to pass '(String key)-arguments' in getPFData method & also to get it need to call getProperty(key) method.
		return value;
		
		
	}
	
	
	
	
	
	
}
