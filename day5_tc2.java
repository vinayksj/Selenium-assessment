//testscript
package assess;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
public class day5_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/ddt.properties/orange.xlsx");
Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("Sheet1");
		//row
		Row row=sh.getRow(0);
		//cell 
		Cell cell=row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
		
		String browser=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(browser);
		
		String url=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(url);
	
		
		String login=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		System.out.println(login);
		
		String password=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		System.out.println(password);
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(login);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		
	}

}

