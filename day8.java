package Pomutility;



import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomutil.orangehrm1;



public class day8 {

    public static void main(String[] args)
            throws AWTException, InterruptedException, IOException {

        // Read properties file

        FileInputStream file =
                new FileInputStream("./src/test/resources/ddt.properties/day8ornge.properties");

        Properties p = new Properties();

        p.load(file);


        // Browser

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(p.getProperty("url"));


        // POM object

        orangehrm1 j = new orangehrm1(driver);


        // Login

        j.getUsername(p.getProperty("untf"));

        j.getPassword(p.getProperty("pwtf"));

        j.getLogin();

        Thread.sleep(2000);


        // Recruitment

        j.getRecruitment();

        Thread.sleep(2000);

        j.getAdd();

        Thread.sleep(2000);


        // Candidate details

        j.getFirstname(p.getProperty("firstname"));

        j.getMiddlename(p.getProperty("middlename"));

        j.getLastname(p.getProperty("lastname"));


        // Vacancy

        j.getVacancy();

        Thread.sleep(1000);


        // Email

        j.getEmail(p.getProperty("email"));


        // Mobile

        j.getMobile(p.getProperty("mobile"));


        // Upload file

        j.getFile(p.getProperty("file"));


        // Application date
        Thread.sleep(3000);
        j.getApplicationDate(p.getProperty("applicationDate"));


        // Save

        j.getSave();

        Thread.sleep(3000);


        // Candidates

        j.getCandidates();

        Thread.sleep(2000);


        // Job Title

        j.getJobTitle();

        Thread.sleep(1000);


        // Vacancy

        j.getCandidateVacancy();

        Thread.sleep(2000);


        // Hiring Manager

        j.getHiringManager();

        Thread.sleep(1000);


        // Status

        j.getStatus();

        Thread.sleep(1000);


        // Candidate Name

        j.getCandidateName(p.getProperty("candidateName"));


        // Application Date

        j.getFromDate(p.getProperty("fromDate"));


        // Search

        j.getSearch();

        Thread.sleep(3000);


        // Logout

        j.getUserDropdown();

        j.getLogout();

    }
}
