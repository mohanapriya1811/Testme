package base;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInstance extends AbstractTestNGCucumberTests {

	private static final ThreadLocal<RemoteWebDriver> remote = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();
	private static final ThreadLocal<Properties> property = new ThreadLocal<Properties>();
	
	public String excelFileName, sheetName;

	public void setDriver(String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			options.setImplicitWaitTimeout(Duration.ofSeconds(30));
			remote.set(new ChromeDriver(options));
		} else if (browser.equals("firefox")) {
			remote.set(new FirefoxDriver());
		}

	}

	public RemoteWebDriver getDriver() {
		return remote.get();
	}

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}
	
	public void setProperty() {
		property.set(new Properties());
	}
	public Properties getProperty() {
		return property.get();
	}
	
}
