package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import baseSuite.InitiateRequest;
import cucumber.api.java.en.*;

public class StepDefinitions {
	
	WebDriver driver;
	InitiateRequest initrequest;
	boolean validation=false;
	boolean request=false;

	@Given("^I hit the get service$")
	public void i_hit_the_get_service() throws Throwable {
		initrequest=new InitiateRequest();
	}

	@Given("^I get the response$")
	public void i_get_the_response() throws Throwable {
		request=initrequest.getRequest();
	}

	@Then("^I validate the response$")
	public void i_validate_the_response() throws Throwable {
	   if(request){
		   validation=initrequest.validateResponse();
	   }else{
		   validation=false;
	   }
	}

	@Then("^validation is successful$")
	public void validation_is_successful() throws Throwable {
	    if(validation){
	    	System.out.println("SUCCESS");
	    }else{
	    	System.out.println("FAIL");
	    }
	}
}
