package rahulshettyacademy;
//36. Introduction to Appium Mobile Gestures 

import java.io.File;
import java.net.MalformedURLException;

import  java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

public class LongPress extends BaseTest{

	
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		String menuTest = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuTest, "Sample menu"); //Will compare expected with actual value
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed()); //Will make sure whatever argument you send inside this assertTrue
																						//that should be true, then only test will pass
	}
	
	//See the Appium automating mobile gestures Github web (you have it saved in favourites)
	
}
