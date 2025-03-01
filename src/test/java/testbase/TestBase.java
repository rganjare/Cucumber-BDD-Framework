package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config;
	
	public static void loadPropFiles() throws IOException {	
		config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\test\\resources\\config.properties");
		config.load(fis);
		System.out.println("Config file has been loaded");
	}
	
	public static void launchBrowser() {	
		if(config.getProperty("Browser").equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if(config.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void openAppURL() {
		driver.get(config.getProperty("AppURL"));
		System.out.println("Application URL loaded");
	}
	
	public static void CloseBrowser() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
