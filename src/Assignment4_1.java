import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment4_1 {

	public static void main(String[] args) {

//	1) Launch new Browser
		WebDriver driver = new FirefoxDriver();
			
//	2) Open URL “http://toolsqa.com/automation-practice-switch-windows/”
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
//	3) Get Window name (Use GetWindowHandle command)
		String winHan=driver.getWindowHandle();
		System.out.println("window name"+winHan);
		
//	4) Click on Button “New Browser Window”, it will open a Pop Up Window
		//driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		driver.findElement(By.id("button1")).click();
		
//	5) Get all the Windows name ( Use GetWindowHandles command)
		Set handles = driver.getWindowHandles();
		System.out.println(handles);
		
//	6) Close the Pop Up Window (Use Switch Command to shift window)
		 for (String handle1 : driver.getWindowHandles()) {
		    System.out.println("window handles are "+handle1);
			driver.switchTo().window(handle1);
			System.out.println("Titles: "+driver.getTitle());
		    }
		 
		 driver.close();
		 driver.quit();

	}

}
