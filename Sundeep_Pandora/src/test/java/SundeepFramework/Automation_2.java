package SundeepFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Automation_2 extends Automation_1 {
	
	
	private static AndroidDriver<AndroidElement> driver = Capability();
	

	
	public static String getCelldata(int rownum, int col) throws IOException
	{
		
		FileInputStream fis  = new FileInputStream("/Users/ssingh/Desktop/data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("script");
		XSSFRow row=sheet.getRow(rownum);
		XSSFCell cell=row.getCell(col);
		return cell.getStringCellValue();

	}
	
	public  void setCelldata(int rownum, int col, String String_1) throws IOException 
	{
		
	
	
		
		FileInputStream fis  = new FileInputStream("/Users/ssingh/Desktop/data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("script");
		sheet.getRow(rownum).createCell(col).setCellValue(String_1);
		FileOutputStream output=new FileOutputStream("/Users/ssingh/Desktop/data.xlsx");
		wb.write(output);
		wb.close();
		

	}
	

	@Test
	public void Pandora_Login() throws InterruptedException, IOException
	{
		
		String value=getCelldata(2,0);
		String value1=getCelldata(2,1);
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Log In']").click();
		//driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys("Sundeep2201@p.com");
		//driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys("abc123");
		
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys(value);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(value1);
		
		Thread.sleep(2000);
		driver.findElementByClassName("android.widget.Button").click();
		Thread.sleep(4000);
		setCelldata(2,2,"LOGIN SUCESS");
		System.out.println("Login to Tier 1 Sucessfull");
		Thread.sleep(4000);
		
	}
	
	
	@Test
	public void Pandora_Test() throws InterruptedException, IOException
	{
		
		String value2=getCelldata(13,0);
		
		Thread.sleep(2000);
		 driver.pressKeyCode(AndroidKeyCode.BACK); 
		 System.out.println("Coachmark Dismissed");
		 Thread.sleep(2000);
		
	driver.findElementByClassName("android.widget.ImageButton").click();
	System.out.println("Hamburger Menu Identified and clicked");
    Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
	System.out.println("Settings Menu Identified and clicked");
    Thread.sleep(2000);
    driver.findElementsByClassName("android.widget.ImageButton").get(0).click();
	Thread.sleep(2000);
    driver.findElementByXPath("//android.widget.TextView[@text='Stations']").click();
    System.out.println("Station Menu Identified and clicked");
	Thread.sleep(2000);
	
	driver.findElementByXPath("//android.widget.TextView[@text='BROWSE']").click();
	System.out.println("Browse Menu Identified and clicked");
	Thread.sleep(2000);
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Browse Genres\"));");
	System.out.println("User is able to scroll brose page sucessfully");
	Thread.sleep(2000);
	driver.findElementByClassName("android.widget.ImageButton").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Stations']").click();
		Thread.sleep(2000);
		
		
		driver.findElementByXPath("//android.widget.TextView[@text='Create Station']").click();
		Thread.sleep(2000);
		
		
		driver.findElementByClassName("android.widget.EditText").sendKeys(value2);
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Shakira']").click();
		Thread.sleep(2000);
		setCelldata(13,1,"STATION PLAYED SUCESSFULLY");
		System.out.println("STATION PLAYED SUCESSFULLY");
		Thread.sleep(2000);
		
		driver.pressKeyCode(AndroidKeyCode.BACK); 
		System.out.println("Coachmark Dismissed");
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		
		
	
		
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Pause']").click();
		setCelldata(21,1,"Play Button Identified");
		setCelldata(21,2,"Paused  Sucessfully");
		System.out.println("System Paused Sucessfully");
		
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Play']").click();
		setCelldata(22,1,"Play Button Identified");
		setCelldata(22,2,"Station Resumed  Sucessfully");
		System.out.println("System Resumed Sucessfully");
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Thumb Down']").click();
		setCelldata(19,1,"Thumbdown Button Identified");
		setCelldata(19,2,"Thumbdown Sucessfully");
		System.out.println("Track Thumb Down Sucessfully");
		
		
		
		
         Thread.sleep(6000);
		 driver.pressKeyCode(AndroidKeyCode.BACK);
		 Thread.sleep(4000);
		
		
	    
	Delete_Station();
	setCelldata(13,2,"STATION DELETED SUCESSFULLY");
	System.out.println("Station Deleted Sucessfully");
	Thread.sleep(2000);
		
		 	
		
	}
	

	 public void Delete_Station() throws InterruptedException
	
	{
		Thread.sleep(2000);
		driver.findElementByClassName("android.widget.ImageButton").click();
		Thread.sleep(2000);
		TouchAction T = new TouchAction(driver);
		Thread.sleep(2000);
		 T.longPress(driver.findElementByXPath("//android.widget.TextView[@text='Shakira Radio']")).release().perform();	
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.TextView[@text='Delete station']").click();
		Thread.sleep(2000);
	
	}
	
	@AfterTest
	public void Pandora_LogoutC() throws InterruptedException
	
	{
		 Thread.sleep(4000);
		driver.findElementByClassName("android.widget.ImageButton").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"version 1802.1\"));");
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.Button[@text='Sign Out']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.Button[2]").click();
		System.out.println("Logged Out Sucessfully");
	
	}
	
	
	
	@Test
	public void Sundeep()
	{
		System.out.println("Hello you have successfully created your first Test");
	}

	
}
