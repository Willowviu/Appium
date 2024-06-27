package rahulshettyacademy;
 
import java.net.MalformedURLException;
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

public class AssignmentExerciseOnAppium extends BaseTest{

	
	@Test
	public void AssigmentEndToEnd() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click(); 
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Fran de Miguel");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("jejejejo.com");
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click(); 

	}
	
	
	
}
