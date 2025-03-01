package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\resources\\features"}, 
					glue = {"stepdefinations"},
					tags = "@EndToEnd",
					plugin = {"html:test-output/cucumber-reports/cucumber-htmlreport.html",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNG_Runner extends AbstractTestNGCucumberTests {

}
