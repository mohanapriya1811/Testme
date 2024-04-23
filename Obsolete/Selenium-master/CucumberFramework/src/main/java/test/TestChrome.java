package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestChrome {

	
	@Test
	public void run() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("linux");
		options.setBrowserVersion("latest");

		Map<String, String> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-mohanapriyav1811-91531");
		sauceOptions.put("accessKey", "9ed5ab1f-f3db-420b-b5fc-8ac170773df2");
		//sauceOptions.put("name", testInfo.getDisplayName());

		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

	  
		WebDriver driver = new RemoteWebDriver(url,options);
		driver.get("https://www.google.com/");
	}
}
