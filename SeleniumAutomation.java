package ui1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAutomation {
	
	public static WebDriver driver;
	public static String browser="edge";
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		if(browser.equals("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
			
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.get("http://thesparksfoundation.sg");
		
		driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/ul/li[5]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[1]/h1/a")).click();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//scroll to bottom page
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.findElement(By.linkText("Internships at Internshala")).click();
		
		//to switch focus to the pop up window
		
		String mainWindowHandle= driver.getWindowHandle();
		
		for(String windowHandle: driver.getWindowHandles()) {
			
			if(!windowHandle.equals(mainWindowHandle)) {
				
				driver.switchTo().window(windowHandle);
				break;
				
			}
			
		}
		
		driver.findElement(By.xpath("//*[@id=\"close_popup\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"marketing_first_container\"]/div/a/div/div/div[3]/span")).click();
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		/*//try {
		Thread.sleep(10000);)
		}
		catch (InterruptedException e) {
            e.printStackTrace();
        }*/
		
		driver.findElement(By.xpath("//*[@id=\"login-list-item\"]/a/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/div[1]/div[1]/input")).sendKeys("solidadkimeu@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/div[1]/div[2]/input")).sendKeys("solidadkimeu8923");
		
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
		
		driver.quit();
	}

}
