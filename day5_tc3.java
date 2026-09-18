package assess;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class day5_3 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		FileReader f = new FileReader("./src/test/resources/ddt.properties/dqsp.json");

        JSONParser j = new JSONParser();

        Object obj = j.parse(f);

        JSONObject json = (JSONObject) obj;

        // Read values from JSON
        String browser = json.get("browser").toString();
        String url = json.get("url").toString();
        String email = json.get("email").toString();
        String username = json.get("username").toString();
        String password = json.get("password").toString();

        // Print values
        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("email: " + email);
        System.out.println("Password: " + password);

        // Close JSON file
        f.close();

        // Browser opening
        WebDriver d = null;

        if (browser.equalsIgnoreCase("chrome")) {

            d = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            d = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            d = new FirefoxDriver();

        } else {

            System.out.println("Invalid browser: " + browser);
            return;
        }

        // Browser settings
        d.manage().window().maximize();

        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open URL
        d.get(url);

        // Login
        d.findElement(By.id("name")).sendKeys(username);
        d.findElement(By.id("email")).sendKeys(email);
        d.findElement(By.id("password")).sendKeys(password);

        d.findElement(By.xpath("//*[@type='submit']")).click();

        // Close browser
        Thread.sleep(2000);
        d.quit();

	}

}
//json data
{
	"browser":"chrome"
	"url":"https://demoapps.qspiders.com/ui?scenario=1"
	"username":"vinay12"
	"email":"vinay@gmail.com"
	"password":"vinay@123"
}
