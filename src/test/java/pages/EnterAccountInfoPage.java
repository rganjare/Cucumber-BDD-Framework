package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testbase.TestBase;

public class EnterAccountInfoPage extends TestBase {
	
	public EnterAccountInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=\"Enter Account Information\"]")
	private WebElement pageText;
	
	@FindBy(xpath="//*[@id=\"id_gender1\"]")
	private WebElement gender_Mr;
	
	@FindBy(xpath="//*[@id=\"id_gender2\"]")
	private WebElement gender_Mrs;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	private WebElement pwd;
	
	@FindBy(xpath="//*[@id=\"days\"]")
	private WebElement dd_Days;
	
	@FindBy(xpath="//*[@id=\"months\"]")
	private WebElement dd_month;
	
	@FindBy(xpath="//*[@id=\"years\"]")
	private WebElement dd_years;
	
	@FindBy(xpath="//*[@id=\"first_name\"]")
	private WebElement first_Name;

	@FindBy(xpath="//*[@id=\"last_name\"]")
	private WebElement last_name;
	
	@FindBy(xpath="//*[@id=\"company\"]")
	private WebElement company;
	
	@FindBy(xpath="//*[@id=\"address1\"]")
	private WebElement address1;
	
	@FindBy(xpath="//*[@id=\"address2\"]")
	private WebElement address2;
	
	@FindBy(xpath="//*[@id=\"country\"]")
	private WebElement country;
	
	@FindBy(xpath="//*[@id=\"state\"]")
	private WebElement state;
	
	@FindBy(xpath="//*[@id=\"city\"]")
	private WebElement city;
	
	@FindBy(xpath="//*[@id=\"zipcode\"]")
	private WebElement zipcode;
	
	@FindBy(xpath="//*[@id=\"mobile_number\"]")
	private WebElement mobile_number;
	
	@FindBy(xpath="//*[text()=\"Create Account\"]")
	private WebElement create_accnt_btn;
	
	@FindBy(xpath="//*[text()=\"Account Created!\"]")
	private WebElement accont_created;
	
	@FindBy(xpath="//*[text()=\"Congratulations! Your new account has been successfully created!\"]")
	private WebElement Congratulations_msg;
	
	@FindBy(xpath="//*[@data-qa=\"continue-button\"]")
	private WebElement continue_btn;
	
	public void verifyAccountInfoPageText(String exp_text) {
		pageText.isDisplayed();
		Assert.assertEquals(pageText.getText(), exp_text);
		System.out.println(pageText.getText()+" is displayed");
	}
	
	public void selectTitle(String title) {
		if(title.equalsIgnoreCase("Mr"))
			gender_Mr.click();
		else
			gender_Mrs.click();
	}
	
	public void enterPassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void selectDOB(String dob) throws InterruptedException {
		String Day = dob.substring(0,2); // 0 & 1 = 10
		String month = dob.substring(3,6); // 3, 4 & 5 = May
		String year = dob.substring(7); // 
		
		Select sel = new Select(dd_Days);
		sel.selectByValue(Day);
		Thread.sleep(1000);
		new Select(dd_month).selectByVisibleText(month);
		Thread.sleep(1000);
		new Select(dd_years).selectByValue(year);
	}

	public void enterAddress(List<Map<String, String>> map) {
		first_Name.sendKeys(map.get(0).get("First_name"));
		last_name.sendKeys(map.get(0).get("Last_name"));
		company .sendKeys(map.get(0).get("Company"));
		address1.sendKeys(map.get(0).get("Address"));
		address2.sendKeys(map.get(0).get("Address2"));
		state.sendKeys(map.get(0).get("State"));
		city.sendKeys(map.get(0).get("City"));
		zipcode.sendKeys(map.get(0).get("Zipcode"));
		mobile_number.sendKeys(map.get(0).get("Mobile_Number"));
	}

	public void verifyAccountCreation() {
		create_accnt_btn.click();
		Assert.assertTrue(accont_created.isDisplayed(), "Account created");
		System.out.println(accont_created.getText());
		Assert.assertTrue(Congratulations_msg.isDisplayed(), "Account created");
		System.out.println(Congratulations_msg.getText());
	}

}
