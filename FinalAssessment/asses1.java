package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Qspiders {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
	WebElement ele1 =driver.findElement(By.id("tog"));
	WebElement ele2 = driver.findElement(By.id("togg"));
	WebElement ele3 = driver.findElement(By.id("toggl"));
	WebElement ele4 = driver.findElement(By.id("toggler"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].removeAttribute('disabled');",ele1);
	js.executeScript("arguments[0].click()",ele1);
	js.executeScript("arguments[0].removeAttribute('disabled');",ele2);
	js.executeScript("arguments[0].click()",ele2);
	js.executeScript("arguments[0].removeAttribute('disabled');",ele3);
	js.executeScript("arguments[0].click()",ele3);
	js.executeScript("arguments[0].removeAttribute('disabled');",ele4);
	js.executeScript("arguments[0].click()",ele4);
	
	driver.findElement(By.id("togglers")).click();
	String s =driver.findElement(By.xpath("//p[@class='text-lg text-orange-600 font-bold text-center']")).getText();
	if(s.contains("ORDER PLACED")) {
		System.out.println("ORDER PLACED");
	}else
		System.out.println("not placed");
}
}
