package rahulshettyacademy;
//51.Testcase-Validating Total amount generated functionality

import java.time.Duration;
import java.util.List;
import java.util.Set;

import java.lang.Double;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest{

	
	@Test
	public void Fillform() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Francisco de Miguel");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); 
		
		//We are using same index(0) cos when you click on Add to Cart button, that WebElement "disappeared" and changed to Added to Cart
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
						
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum =0;
		for(int i=0; i<count;i++)
		{
			String amountString = productPrices.get(i).getText();
			//   $160.07 -> We are saying: give me the substring which starts from the 1st index
			Double price = getFormattedAmount(amountString); //Like this we remove the 1st character ($) -> 0 index
			//   As integer does not support decimals values -> we will write: double, but now the values are in String format, and we cannot sum 2 strings
			//   so we will pass Double.parseDouble and the return will be double value -> the method getFormattedAmount is in our BaseTest
			totalSum = totalSum + price; //160.07 + 120.0 = 280.97
		
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		//Assert.assertEquals(totalSum, displayFormattedSum);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		//Thread.sleep(6000);
		driver.close();
		
		/*driver.findElement(By.xpath("android.widget.Button[@resource-id=\"KByQx\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Rechazar todo']")).click();
		
		
		Set<String> context = driver.getContextHandles(); //this method will get you all the context present for your app on that mode
		for(String contextName :context)
		{
			System.out.println(contextName);
		}	
		
		driver.context("WEBVIEW_com.androidsample.generalstore"); //chrome driver
		driver.findElement(By.name("q")).sendKeys("world surf league");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		*/
		 
		/*Hybrid - Google page ->
		//***FAMOUS INTERVIEW QUESTION***
		//How do you handle a hybrid app which involves both native Android and Web browsers?
		
		
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		*/
	}
}

//Its giving me an failure ->  id: com.androidsample.generalstore:id/toolbar_title]; FAILED: Fillform; errors#stale-element-reference-exception




