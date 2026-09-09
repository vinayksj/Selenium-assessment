package assessment;

import java.time.Duration;

public class testcase1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/reg/?entry_point=login");
		
		WebElement first_n = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement last_n = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		int first_name=first_n.getLocation().getY();
		int last_name=last_n.getLocation().getY();
		Thread.sleep(2000);
		if(first_name==last_name) {
			System.out.println("they are aligned in same line");
		}else
			System.out.println("they are not aligned");
		
	}

}
