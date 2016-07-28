import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Assignment3_2 {

	public static void main(String[] args) throws InterruptedException {
		
	//	1. Goto site: http://jqueryui.com/droppable/#shopping-cart
//		2. Drag & drop below products to Shopping Cart:
//		Cheezeburger Shirt
//		Aligator Leather bag
//		iPhone
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://jqueryui.com/droppable/#default");
	    driver.manage().window().maximize();
	 
	    Actions act = new Actions(driver);
	 
	    // Script for dragging an element and dropping it in another place
	    WebElement iFrame = driver.findElement(By.tagName("iframe"));
	    System.out.println(iFrame.getSize());
	    driver.switchTo().frame(iFrame);
	 
	    WebElement From = driver.findElement(By.id("draggable"));
	    System.out.println(From.getLocation());
	 
	    WebElement To = driver.findElement(By.id("droppable"));
	    System.out.println(To.getLocation());
	 
	    act.dragAndDrop(From, To).build().perform();
	}

}
