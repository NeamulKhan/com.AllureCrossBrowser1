package stepDefinationAllureCrossBrowser1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilityAllureCrossBrowser1.BaseClassAllureCrossBrowser1;

public class ImageSliderAllureOneBrowser1 extends BaseClassAllureCrossBrowser1 {
	
	
	@Given("I am on the website homepage")
	public void i_am_on_the_website_homepage() {
	   
		allureCrossBrowser1_launchURL();
	}

	@Then("the homepage image slider should be visible")
	public void the_homepage_image_slider_should_be_visible() {
	    
		
	}

	@When("I wait for the image slider to change")
	public void i_wait_for_the_image_slider_to_change() {
	  
		
	}

	@Then("the displayed image should be different from the previous one")
	public void the_displayed_image_should_be_different_from_the_previous_one() {
	   
		
	}




}
