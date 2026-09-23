package FinalAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {
public static void main(String[] args)throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
	WebElement ele1 = driver.findElement(By.id("dragElement1"));
	WebElement ele2 = driver.findElement(By.id("dragElement2"));
	WebElement ele3 = driver.findElement(By.id("dragElement3"));
	WebElement ele4 = driver.findElement(By.id("dragElement4"));
	WebElement mac = driver.findElement(By.id("dropZone1"));
	System.out.println(mac.getLocation());
	WebElement lac = driver.findElement(By.id("dropZone2"));
	System.out.println(lac.getLocation());
	Actions act = new Actions(driver);
	act.dragAndDropBy(ele2, 651, 108);
	Thread.sleep(2000);
	act.dragAndDropBy(ele4, 651, 108);
	Thread.sleep(2000);
	act.dragAndDropBy(ele1, 651, 321);
	Thread.sleep(2000);
	act.dragAndDropBy(ele3, 651, 321);
}
}
