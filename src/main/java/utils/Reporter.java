package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class Reporter {

	ExtentSparkReporter extent = new ExtentSparkReporter("./report/htmlreport.html");
	ExtentReports report = new ExtentReports();
	
	
	
	
}
