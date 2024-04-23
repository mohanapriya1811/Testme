package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ActionClass {
@Test
public void actionClass() {
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	
	Shadow shad = new Shadow(driver);
	
	WebElement ele = shad.findElementByXPath("//textarea[@id='APjFqb']");
		
	Actions act = new Actions(driver);
	
	//act.sendKeys(ele, "lambdatest").perform();
	//act.keyDown(ele, Keys.SHIFT).sendKeys("lamdatest").perform();
	
	//act.sendKeys(ele, "lambdatest").sendKeys(Keys.ENTER).perform();
	
	act.sendKeys(ele, "lambdaTest").perform();
	
	act.keyDown(ele, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	act.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();
	
	act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	
}
}
