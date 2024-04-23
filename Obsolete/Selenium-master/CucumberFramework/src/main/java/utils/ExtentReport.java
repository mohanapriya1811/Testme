package utils;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import runner.RunnerClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExtentReport{

	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<String> testName = new ThreadLocal<String>();

	private String fileName = "result.html";
	private String pattern = "DD-MM-YY HH-MM-SS";

	public String testcaseName, testDescription, testAuthor, testCategory;

	public String folderName;

	@BeforeSuite(alwaysRun = true)
	public synchronized void startReport() {

		String date = new SimpleDateFormat(pattern).format(new Date());
		String replace = date.replace(" ", "_");

		folderName = "reports/" + replace;
		File folder = new File("./"+folderName);

		if (!folder.exists()) {
			folder.mkdir();
		}

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./" + folderName + "/" + fileName);
		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Testleaf");
		reporter.config().setEncoding("UTF-8");
		reporter.config().setReportName("Test Execution Report");
		reporter.setAppendExisting(true);

		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}

	@BeforeClass(alwaysRun = true)
	public synchronized void startTestCase() {
		ExtentTest parent = extent.createTest(testcaseName, testDescription);
		parent.assignAuthor(testAuthor);
		parent.assignCategory(testCategory);
		parentTest.set(parent);
		testName.set(testcaseName);
	}

	public synchronized void setNode() {

		ExtentTest child = parentTest.get().createNode(testName.get());
		test.set(child);
	}

	public String takesnap() {
		long number = (long) Math.random() * 999999 + 1000000;
		return Long.toString(number);
	}

	public void reportStep(String stepInfo, String status, boolean bSnap) throws IOException {
		synchronized (test) {
			MediaEntityModelProvider img = null;
			// long snapNum = takesnap();
			if (bSnap && !(status.equalsIgnoreCase("INFO") || status.equalsIgnoreCase("SKIPPED"))) {
				try {
					img = MediaEntityBuilder
							.createScreenCaptureFromBase64String("../" + folderName + "/images/" + takesnap() + ".jpeg")
							.build();

				} catch (IOException e) {

				}
			}
			if (status.equalsIgnoreCase("pass")) {
				test.get().pass(stepInfo, img);
			}
			else if(status.equalsIgnoreCase("fail")) {
				test.get().fail(stepInfo, img);
				throw new RuntimeException("See the Report for More Details");
			}
			else if(status.equalsIgnoreCase("info")) {
				test.get().info(stepInfo);
			}
			else if(status.equalsIgnoreCase("skipped")) {
				test.get().skip("Test is skipped due to Dependeny");
			}
			else if(status.equalsIgnoreCase("warning")) {
				test.get().warning(stepInfo, img);
			}
		}
	}

	public void reportStep(String stepInfo, String status) throws IOException {
		reportStep(stepInfo, status, true);
	}

	/*
	 * public String getTestcaseName() { return testName.get(); }
	 */

	public Status getStatus() {
		return parentTest.get().getModel().getStatus();
	}
	@AfterSuite(alwaysRun =true)
	public void endReport() {
		extent.flush();
	}
}
