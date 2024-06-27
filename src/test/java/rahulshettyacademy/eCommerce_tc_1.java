package rahulshettyacademy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{

	
	@Test
	public void Fillform() throws InterruptedException
	{
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Francisco de Miguel");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");
		
		
		
		
	}
}

/****FAMOUS INTERVIEW QUESTION***
 How do you get the text present of a toast message?
 We should tell that definitely it will have a tag name like widget.toast, so based upon which toast I want, I'll call with xpath, and on the message
 on the toast can be retrieved with the attribute of name
 
 */





