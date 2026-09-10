package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class day3_tc2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
        driver.findElement(By.xpath("//*[@viewBox='0 0 1024 1024']")).click();
        driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]")).click();
        driver.findElement(By.xpath("//div[text()='10']")).click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().contains("date")) {
       	 System.out.println("DateField-result page is displayed");
        }else {
       	 System.out.println("DateField-result page is not displayed");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
