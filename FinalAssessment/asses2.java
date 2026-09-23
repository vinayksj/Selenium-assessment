package FinalAssessment;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QspiderSlider {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
	WebElement sld = driver.findElement(By.id("slide"));
	Actions act = new Actions(driver);
	act.clickAndHold(sld).moveByOffset(100, 0).release().perform();
	boolean ele =driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']")).isDisplayed();
	System.out.println(ele);
	}
}
