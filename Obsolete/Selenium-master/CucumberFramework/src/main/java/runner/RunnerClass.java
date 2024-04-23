package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentReport;

import org.testng.annotations.Test;

import base.BaseClass;
import baseCucumber.BaseCucumber;

@Test
@CucumberOptions(features = "src/main/java/feature", glue = {"pages", "baseCucumber"}, 
monochrome = true
//tags = "not @Login"
//tags = "@Datatable")
)
public class RunnerClass extends BaseClass{

}
