package stepdefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ICICI_Bank_Steps {
	
	@Given("user navigated to the ICICI Bank url")
	public void user_navigated_to_the_icici_bank_url() {
	   System.out.println("user navigated to the ICICI Bank url");
	}

	@Then("user verified the login status")
	public void user_verified_the_login_status() {
		 System.out.println("user verified the login status");
	}
	
	@When("User logged in")
	public void user_logged_in() {
		 System.out.println("User logged in");
	}

	@When("user did fund transfer")
	public void user_did_fund_transfer() {
		 System.out.println("user did fund transfer");
	}

	@Then("user verified the fund transfer status")
	public void user_verified_the_fund_transfer_status() {
		 System.out.println("user verified the fund transfer status");
	}
	
	@Then("user validated the transfer amount and currency")
	public void user_validated_the_transfer_amount_and_currency(io.cucumber.datatable.DataTable dataTable) {
	    
		List <List <String>> data = dataTable.asLists();
		
		System.out.println(data.get(0).get(0) +"---"+data.get(0).get(1) );
		System.out.println(data.get(1).get(0) +"---"+data.get(1).get(1) );
		System.out.println(data.get(2).get(0) +"---"+data.get(2).get(1) );
		System.out.println("@@@@@@@@@@@@@@@@@ Map Data @@@@@@@@@@@@@@@@@");
		
		List <Map <String, String>> map = dataTable.asMaps();
		System.out.println(map.get(0).get("currency") +"---"+map.get(0).get("amount") );
		System.out.println(map.get(1).get("currency") +"---"+map.get(1).get("amount") );
		System.out.println(map.get(2).get("currency") +"---"+map.get(2).get("amount") );
		
	}
}
