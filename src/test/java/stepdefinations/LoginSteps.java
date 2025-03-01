package stepdefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import testbase.TestBase;

public class LoginSteps { // control+shift+O
	
	public HomePage hp = new HomePage();
	
	@Given("user navigated to the instagram url")
	public void user_navigated_to_the_instagram_url() {	   
		System.out.println("user navigated to the instagram url");
	}

	@Then("User validated the title of the page")
	public void user_validated_the_title_of_the_page() {
		hp.verifyTitleOfThePage();
	}

	@When("User entered username")
	public void user_entered_username() {    
		System.out.println("User entered username");
	}

	@When("user entered password")
	public void user_entered_password() {   
		System.out.println("user entered password");
	}

	@When("user clicked on login button")
	public void user_clicked_on_login_button() {
		System.out.println("user clicked on login button");
		hp.clickOnLoginBtn();
	}

	@Then("user should logged in")
	public void user_should_logged_in() {
		System.out.println("user should logged in");
		hp.verifyUserLogin();
	}
	
	@Given("user navigated to the facebook url")
	public void user_navigated_to_the_facebook_url() {
		System.out.println("user navigated to the facebook url");
	}
	
	@Given("user navigated to the instagram url as {string}")
	public void user_navigated_to_the_instagram_url_as(String AppURL) {
		System.out.println("user navigated to the instagram url" 
				+AppURL);
	}
	@When("User entered username as {string}")
	public void user_entered_username_as(String username) {
		
		System.out.println("User entered username: " +username);
	}
	@When("user entered password as {string}")
	public void user_entered_password_as(String password) {
		System.out.println("User entered password: " +password);
	}
	
	@When("user did fund transfer in different currencies")
	public void user_did_fund_transfer_in_different_currencies(io.cucumber.datatable.DataTable dataTable) {
	    
		List <List <String>> data = dataTable.asLists();
		
		System.out.println("First row-first col:" +data.get(0).get(0)+"--- "+"First row- second col:" +data.get(0).get(1));
		System.out.println("second row-first col:" +data.get(1).get(0)+"--- "+"Second row- second col:" +data.get(1).get(1));
		System.out.println("Third row-first col:" +data.get(2).get(0)+"--- "+"Third row- second col:" +data.get(2).get(1));
	
		System.out.println("########### Data from Map ####################");
		List <Map <String, String>> map = dataTable.asMaps();
		System.out.println("First row-first col:" +map.get(0).get("Currency")+"--- "+"First row- second col:" +map.get(0).get("Amount"));
		System.out.println("second row-first col:" +map.get(1).get("Currency")+"--- "+"Second row- second col:" +map.get(1).get("Amount"));
		System.out.println("Third row-first col:" +map.get(2).get("Currency")+"--- "+"Third row- second col:" +map.get(2).get("Amount"));
	}
	
	@Given("user navigated to the application url")
	public void user_navigated_to_the_application_url() {	
		TestBase.openAppURL(); 
	}
	
	@When("User entered {string} and {string}")
	public void user_entered_and(String username, String password) {   
		hp.enterUserDetails(username, password);
	}
	
	@When("user login with his credntials")
	public void user_login_with_his_credntials(io.cucumber.datatable.DataTable dataTable) {
		List <List <String>> data = dataTable.asLists();
		hp.enterUserDetails(data.get(0).get(0), data.get(0).get(1));
		hp.clickOnLoginBtn();
	}
	@Then("user should be able to delete the account")
	public void user_should_be_able_to_delete_the_account() throws InterruptedException {
		hp.deleteAccount();
	 
	}
	
}
