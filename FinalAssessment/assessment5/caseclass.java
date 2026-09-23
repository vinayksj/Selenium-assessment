package BaseClassUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomutilities.OrangePOM;

public class BaseOrange {

    protected WebDriver driver;

    protected Properties prop;

    @BeforeSuite
    public void Bs() {

        System.out.println("Establish database connectivity");

    }

    @BeforeTest
    public void Bt() {

        System.out.println("Pre conditions");

    }

    @BeforeClass
    public void Bc() throws Exception {
        FileInputStream fis = new FileInputStream( "./src/test/resources/DDT/Orangehrm.properties");
        prop = new Properties();
        prop.load(fis);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Launch the browser");
    }

    @BeforeMethod
    public void Bm() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        OrangePOM login = new OrangePOM(driver);
        login.getUname(prop.getProperty("Username"));
        login.getPass(prop.getProperty("Password"));
        login.getLogin();
        System.out.println("Application opened");
    }

    @AfterMethod
    public void Am() {
        System.out.println("Logout executed");
    }
    @AfterClass
    public void Ac() {
        driver.quit();
        System.out.println("Close browser");
    }
    @AfterTest
    public void At() {
        System.out.println("Post conditions");
    }

    @AfterSuite
    public void As() {
        System.out.println("Close database connectivity");
    }
}
