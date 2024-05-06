package base;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import design.SeleniumBase;
import utils.ExtentReport;
import utils.ReadExcelData;

public class ProjectSpecificMethods extends SeleniumBase{

	@Parameters({"language"})
	@BeforeMethod
	public void preCondition(@Optional ("langName") String lang) throws IOException {
		//String property = System.getProperty("propertyName");
		if(lang.equals("english")) {
			setProperty();
			FileInputStream fis = new FileInputStream("src/main/resources/config_english.properties");
			getProperty().load(fis);
			fis.close();
			}
			else if(lang.equals("french")){
			setProperty();
			FileInputStream fis = new FileInputStream("src/main/resources/config_french.properties");
			getProperty().load(fis);
			fis.close();
			}
		
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		setNode();
	
	}
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	@DataProvider(name = "fetchData", indices=0)
	public Object[][] getData() throws IOException, InterruptedException {
		return ReadExcelData.readData(excelFileName, sheetName);
	}
}
