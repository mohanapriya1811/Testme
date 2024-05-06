package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriver.Timeouts;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.DataUsingCsv;
import utils.DataUsingDB;
import utils.ExtentReport;
import utils.ReadExcelData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.dockerjava.api.model.Capability;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class BaseClass extends AbstractTestNGCucumberTests {

	public static Properties prop;
	public String excelFileName, sheetName;
	public static WebDriver driver;

	public static ExtentReports extent;
	public static ExtentTest test;
	public String testcaseName, testDescription, testAuthor, testCategory;

	@Parameters({ "language" })
	@BeforeMethod
	public void preCondition(@Optional("langName") String lang) throws IOException {

		if (lang.equals("english")) {
			FileInputStream fis = new FileInputStream("src/main/resources/config_english.properties");
			prop = new Properties();
			prop.load(fis);
			fis.close();

		}

		else if (lang.equals("french")) {
			FileInputStream fis = new FileInputStream("src/main/resources/config_french.properties");
			prop = new Properties();
			prop.load(fis);
			fis.close();

		}

		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities dc = new DesiredCapabilities();
		options.setCapability("browserName", "chrome");
		options.setCapability("platformName", Platform.LINUX);

		//driver = new RemoteWebDriver(new URL("https://mohanapriya1811:f9bed5fc-1206-445b-8c62-234198b24678@ondemand.us-west-1.saucelabs.com:443/wd/hub"), options);
		driver = new RemoteWebDriver(new URL("http://172.17.0.1:4444/wd/hub"), options);
		
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/main");

	}

	@AfterMethod
	public void postCondition() {
		driver.close();

	}

	@DataProvider(name = "fetchData")
	public Object[][] sendData() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		return ReadExcelData.readData(excelFileName, sheetName);
		// return DataUsingDB.getData();
		// return DataUsingCsv.getData();
	}

	@BeforeSuite
	public void startReport() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass(alwaysRun = true)
	public synchronized void testDetails() {
		test = extent.createTest(testcaseName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@BeforeTest
	public void setValue() {

		excelFileName = "Data_Sheet";
		sheetName = "Login";
		testcaseName = "CreateLead";
		testDescription = "Verify Lead functionality with positive data";
		testAuthor = "Hari";
		testCategory = "Smoke";

	}

	public int takeSnap() throws IOException {

		int ranNum = (int) (Math.random() * 999999 + 1000000);

		File source = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + ranNum + ".png");
		FileUtils.copyFile(source, target);

		return ranNum;
	}

	public void reportStep(String stepInfo, String status) throws IOException {
		int snapNum = takeSnap();

		if (status.equalsIgnoreCase("pass")) {
			System.out.println(test.pass(stepInfo,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + snapNum + ".png").build()));
		} else if (status.equalsIgnoreCase("fail")) {
			test.fail(stepInfo,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + snapNum + ".png").build());

		}
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

}
