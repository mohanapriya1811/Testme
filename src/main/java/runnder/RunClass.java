package runnder;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features={"src/main/java/features/CreateIncident.feature"}, glue="steps",
tags = "@RunTest", plugin= {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class RunClass  extends AbstractTestNGCucumberTests{

}
