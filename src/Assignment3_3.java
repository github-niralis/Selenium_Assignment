import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment3_3 {

	public static void main(String[] args) {
		
//		1. Goto site: http://jqueryui.com/slider/#hotelrooms
//		2. Move slider to right side till ‘Minimum number of beds’
//		dropdown contains value ‘5’
		
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://jqueryui.com/slider/#hotelrooms");
	    driver.manage().window().maximize();
	    
	    WebElement iFrame = driver.findElement(By.tagName("iframe"));
	    System.out.println(iFrame.getSize());
	    driver.switchTo().frame(iFrame);
	    
	    Select objSelect = new Select(driver.findElement(By.id("minbeds")));
	    objSelect.selectByIndex(4);
	    System.out.println(driver.findElement(By.cssSelector(".ui-slider-handle")).getLocation());
	    
//	    Actions act = new Actions(driver);
//	    WebElement From = driver.findElement(By.cssSelector(".ui-slider-handle"));
//	    
//	    act.clickAndHold().dragAndDropBy(From, 455, 250);
	}

}
