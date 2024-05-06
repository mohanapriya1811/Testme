package design;

import java.time.Duration;

import utils.ExtentReport;

public class SeleniumBase extends ExtentReport implements Browser{

	@Override
	public void startApp(String browser, String url) {
			setDriver("chrome");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			getDriver().get(url);
		
	}

	@Override
	public void startApp(String browser, String url, boolean headless) {
		switch(browser) {
		case "chrome":
			setDriver("chrome");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			getDriver().get("http://leaftaps.com/opentaps/control/main");
		case "firefox":
			setDriver("firefox");
			getDriver().get(url);
		}
		
	}
	

}
