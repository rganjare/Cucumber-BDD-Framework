package stepdefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EnterAccountInfoPage;
import pages.HomePage;

public class RegisterNewUser_Steps {
	HomePage hp = new HomePage();
	EnterAccountInfoPage acntInfoPage = new EnterAccountInfoPage();
	
	@And("user entered Name and Email Address")
	public void user_entered_name_and_email_address(io.cucumber.datatable.DataTable dataTable) {
		List <List <String>> data = dataTable.asLists();
		hp.verifyTitleOfThePage();
		hp.enterNewUserSignUpDetails(data.get(0).get(0), data.get(0).get(1));
	}
	
	@And("user clicked on SignUp button")
	public void user_clicked_on_sign_up_button() {
	   hp.clickOnNewUserSignupBtn();
	}
	
	@And("User entered the account information")
	public void user_entered_the_account_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List <Map <String, String>> map = dataTable.asMaps();
		acntInfoPage.verifyAccountInfoPageText("ENTER ACCOUNT INFORMATION");
		acntInfoPage.selectTitle(map.get(0).get("Title"));
		acntInfoPage.enterPassword(map.get(0).get("password"));
		acntInfoPage.selectDOB(map.get(0).get("DOB"));
		acntInfoPage.enterAddress(map);
	}
	
	
	@Then("Verify user account is created")
	public void verify_user_account_is_created() {
		acntInfoPage.verifyAccountCreation();
		
	}

}
