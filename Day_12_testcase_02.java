package baseclassU;



import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClassUtility.ornageBaseClass;
import pomutil.homepage;
import pomutil.myinfopage;



public class Day_12_testcase_02 extends ornageBaseClass {

	@Test(priority = 1)
	public void infoTest() throws EncryptedDocumentException, IOException, InterruptedException {
		//reading data from excel file
		FileInputStream file = new FileInputStream("./src/test/resources/testng.properties/orangecase.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet2");
		Row row = sh.getRow(1);
		
		DataFormatter df = new DataFormatter();
		String fN = df.formatCellValue(row.getCell(0));
		String lN = df.formatCellValue(row.getCell(1));
		String EId = df.formatCellValue(row.getCell(2));
		
		// object creation for home page
		homepage h = new homepage(d);
		//click my info
		h.getInfoLink();
		
		// object creation for my info page
		myinfopage m = new myinfopage(d);
		Thread.sleep(2000);
		//first name
		m.getFN(fN);
		Thread.sleep(2000);
		//last name
		m.getLN(lN);
		Thread.sleep(2000);
		//employee id
		m.getEId(EId);
		Thread.sleep(2000);
		//click save
		m.getSavebtn();
		
	}
	
	@Test(priority = 2)
	public void verify() throws InterruptedException {
		
		// object creation for home page
		homepage h = new homepage(d);
		//click my info
		h.getInfoLink();
		
		// object creation for my info page
		myinfopage m = new myinfopage(d);
		
		//printing details
		Thread.sleep(2000);
		System.out.println("First Name: " + m.verifyFN());
		Thread.sleep(2000);
	    Thread.sleep(2000);
	    System.out.println("Last Name: " + m.verifyLN());
	    Thread.sleep(2000);
	    System.out.println("Employee ID: " + m.verifyEId());
	    
	    Thread.sleep(2000);
	    
	    //verifying using assert 
		Assert.assertEquals(m.verifyFN(), "vinay");
		Thread.sleep(2000);
		
		Assert.assertEquals(m.verifyLN(), "k");
		Thread.sleep(2000);
		Assert.assertEquals(m.verifyEId(), "1011");
		Thread.sleep(2000);
		System.out.println("Record Found");
	}
	
}