package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testbase.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
	PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//*[text()=\" Signup / Login\"]")
	private static WebElement signup_btn;
	
	//WebElement signup_btn = driver.findelemnet(By.xpath("//*[text()=\" Signup / Login\"]"))
	
	@FindBy(xpath="//*[@data-qa=\"login-email\"]")
	private static WebElement login_email;
	
	@FindBy(xpath="//*[@data-qa=\"login-password\"]")
	private static WebElement login_password;
	
	@FindBy(xpath="//*[@data-qa=\"login-button\"]")
	private static WebElement login_btn;
	
	@FindBy(xpath="//*[text()=\"Your email or password is incorrect!\"]")
	private static WebElement login_error_msg;
	
	@FindBy(xpath="//*[text()=\" Logout\"]")
	private static WebElement logout;
	
	@FindBy(xpath = "//*[@name=\"name\"]")
	private static WebElement name;

	@FindBy(xpath = "//*[@name=\"email\"][@data-qa=\"signup-email\"]")
	private static WebElement signup_email;

	@FindBy(xpath = "//*[@data-qa=\"signup-button\"]")
	private static WebElement signup_btn_new_user;
	
	@FindBy(xpath="//*[text()=\" Delete Account\"]")
	private WebElement delete_acnt_btn;
	
	@FindBy(xpath="//*[text()=\"Account Deleted!\"]")
	private WebElement accont_deleted;
	
	@FindBy(xpath="//*[text()=\"Your account has been permanently deleted!\"]")
	private WebElement delete_msg;
	
	@FindBy(xpath="//*[text()=\" Logout\"]")
	private WebElement Logout_btn;
	
	public void verifyTitleOfThePage() {
		String actuatl_title = driver.getTitle();
		System.out.println(actuatl_title);
		Assert.assertEquals(actuatl_title, "Automation Exercise");
	}
	
	public void enterUserDetails(String username, String password) {
		signup_btn.click();
		login_email.sendKeys(username);
		login_password.sendKeys(password);
	}
	
	public void clickOnLoginBtn() {
		login_btn.click();
	}
	
	public void verifyUserLogin() {	
		
		boolean value = false;
		
		try {
			value = login_error_msg.isDisplayed();
		} catch(Exception e) {
			e.getMessage();
		}
				
		if(value) {
			login_error_msg.isDisplayed();	
			Assert.assertFalse(value, login_error_msg.getText()+ " error message is displayed"); 
			System.out.println("Invalid user");
		} else {
			Assert.assertTrue(logout.isDisplayed(), logout.getText()+ "is displayed");
			System.out.println("Valid user");
		}
				
	}

	public void enterNewUserSignUpDetails(String username, String signupemail) {
		signup_btn.click();
		name.sendKeys(username);
		signup_email.sendKeys(signupemail);
	}
	
	public void clickOnNewUserSignupBtn() {
		signup_btn_new_user.click();
	}

	public void deleteAccount() throws InterruptedException {	
		Logout_btn.isDisplayed();
		delete_acnt_btn.isDisplayed();
		delete_acnt_btn.click();
		Thread.sleep(2000);
		Assert.assertTrue(accont_deleted.isDisplayed(), "User account Deleted");
		System.out.println(accont_deleted.getText());
		Thread.sleep(2000);
		Assert.assertTrue(delete_msg.isDisplayed());
		Assert.assertEquals(delete_msg.getText(), "Your account has been permanently deleted!");
	}
	
 }
