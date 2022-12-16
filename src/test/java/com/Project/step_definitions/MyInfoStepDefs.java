package com.Project.step_definitions;


import com.Project.pages.SelfPage;
import com.Project.pages.SignInPage;
import com.Project.utilities.Driver;
import com.Project.utilities.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;


public class MyInfoStepDefs {

	@Given("user logs in using {string} credentials")
	public void userLogsInUsingCredentials(String role) {

		Driver.get().get(Environment.URL);
		Driver.get().manage().window().maximize();
		SignInPage signInPage = new SignInPage();
		signInPage.login(role);

	}

	@When("user is on the my self page")
	public void user_is_on_the_my_self_page() {
	    SelfPage selfPage = new SelfPage();
	    selfPage.goToSelf();
		
	}






	
}
