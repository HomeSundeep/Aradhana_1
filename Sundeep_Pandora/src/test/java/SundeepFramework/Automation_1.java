package SundeepFramework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Automation_1 {



public static AndroidDriver<AndroidElement> Capability() {
		
		// Getting APK file
		File F = new File("src");
		File fs = new File(F,"android-dev-1802.1RC2-0-g3226e20072.apk");
		
		
		
		
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability(MobileCapabilityType.DEVICE_NAME, "Sundeep");  
		DC.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		
		// Connection to Server
		AndroidDriver<AndroidElement> driver = null;
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),DC);
		} catch (MalformedURLException exception) {
			// handle exception
		}
		return driver;
	}

}
