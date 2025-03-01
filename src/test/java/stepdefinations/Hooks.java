package stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import testbase.TestBase;

public class Hooks {

	@BeforeAll
	public static void loadPropFiles() throws IOException {
		TestBase.loadPropFiles();
	}
	
	@Before()
	public void setUp() {
		System.out.println("Launching the browser");
		TestBase.launchBrowser();
	}

	@After()
	public void tearDown() {
		System.out.println("####### Quiting the browser #####");
		TestBase.CloseBrowser();
	}
	
	@AfterAll
	public static void db_Close() {
		System.out.println("@@@@ Execution Completed-Closing DataBase @@@@@");
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException, InterruptedException
	{
		WebDriver driver = TestBase.driver;
		if(scenario.isFailed()) {
		//screenshot
		File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		Thread.sleep(2000);
		scenario.attach(fileContent,"image/png", "image");
		
		}
		
	}
	
}