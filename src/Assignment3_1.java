import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Assignment3_1 {

	public static void main(String[] args) throws InterruptedException {
		
//		1. Goto site: http://www.makemytrip.com/
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.makemytrip.com/international-flights");
		//driver.manage().window().maximize();
		Actions actions =new Actions(driver);
//		2. Enter 'Pune' in 'From' textbox
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from_typeahead1")));
		driver.findElement(By.id("from_typeahead1")).sendKeys("Pune");
				
//		3. Select option 'Mahabaleshwar, India (nearest airport Pune, PNQ)'
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Mahabaleshwar')]")));
		driver.findElement(By.xpath("//div[@class='tt-dataset-3']/descendant::div[2]/p")).click();
		
//		4. Enter 'New York' in 'To' textbox
		driver.findElement(By.id("to_typeahead1")).sendKeys("New York");
				
//		5. Select option 'New York, US - John F Kennedy (JFK)'
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		
//		6. Select 'Departure' date '30-july-2016'
		driver.findElement(By.xpath("//a[@id='start_date_sec']/span[contains(text(), 'Select Date')]")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'July')]/ancestor::div/descendant::table[1]/descendant::a[text()='30']")).click();
		
//		7. Select 'Return' date '2-Aug-2016'
		driver.findElement(By.xpath("//a[@id='return_date_sec']/span[contains(text(), 'Select Date')]")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'August')]/ancestor::div/descendant::table[1]/descendant::a[text()='2']")).click();
		
//		8. Select no of Adults: 4 & Child: 2
		
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='adult_count']/a[2]")));
		actions.click().perform();
		actions.click().perform();
		actions.click().perform();
		
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='child_count']/a[2]")));
		actions.click().perform();
		actions.click().perform();
		
//		9. Select class: 'First'
		Select objSelect = new Select(driver.findElement(By.name("select_class")));
		objSelect.selectByValue("F");
		Thread.sleep(3000);
//		10. Click on 'Search Flights'
		driver.findElement(By.id("flights_submit")).click();
		
//		11. Verify message 'Aaahh! No flights found.'
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".container"))));
		String msg= driver.findElement(By.cssSelector(".container")).getText();
		msg.contains("Aaahh! No flights found.");
		System.out.println("Verification successful");
		
		driver.close();
	}

}
