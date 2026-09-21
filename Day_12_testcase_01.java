package baseclassU;


import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import baseClassUtility.ornageBaseClass;
import pomutil.homepage;
import pomutil.recruitmentpage;

public class Day_12_testcase_01 extends ornageBaseClass {

	
	@Test
	public void Vacancies() throws IOException, InterruptedException, AWTException {
		//read data from excel 
		FileInputStream file = new FileInputStream("./src/test/resources/testng.properties/orangecase.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		
		String vName = row.getCell(0).getStringCellValue();
		String Jobtitle = row.getCell(1).getStringCellValue();
		String description = row.getCell(2).getStringCellValue();
		String HR = row.getCell(3).getStringCellValue();
		String positions = row.getCell(4).getStringCellValue();
		
		Thread.sleep(2000);
		// object creation for home page
		homepage h = new homepage(d);
		h.getRecruitmentLink();
		
		// object creation for recruitment page
		recruitmentpage r = new recruitmentpage(d);
		
		//click on vacancies
		r.getVaccLink();
		Thread.sleep(2000);
		//click on add button
		r.getAddbtn();
		Thread.sleep(2000);
		//vacancy name
		r.getVName(vName);
		//job title
		r.getJobtitle();
		//description
		r.getDescription(description);
		//HR
		r.getHR(HR);
		//position
		r.getPositions(positions);
		//click on save button
		r.getSavebtn();
		
		
	}
}