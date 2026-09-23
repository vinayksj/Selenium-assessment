package testscript;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;
import BaseClassUtility.BaseOrange;
import pomutilities.OrangeBuzzPOM;
import pomutilities.OrangeTextPOM;

public class FinalAssessment5 extends BaseOrange {

	@Test
	public void buzz() throws Exception {
		OrangeBuzzPOM obp = new OrangeBuzzPOM(driver);
		obp.clickBuzz();
		FileInputStream file = new FileInputStream("./src/test/resources/DDT/Orangehrm.properties");
		Properties p = new Properties();
		p.load(file);
		String mssg =p.getProperty("text");
		OrangeTextPOM otp = new OrangeTextPOM(driver);
		otp.getNews(mssg);
		otp.clickPost();
		otp.getRecent(mssg);
		otp.getPost(mssg);
		
	}
}
