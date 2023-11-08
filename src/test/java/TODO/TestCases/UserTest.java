package TODO.TestCases;

//import org.json.JSONObject;
import org.testng.annotations.Test;

import Apis.UserApi;
import TODO.TestCases.Models.User;
import data.errorMessages;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

//import com.aventstack.extentreports.model.Log;

//import io.restassured.http.ContentType;

import io.restassured.response.Response;
import steps.UserSteps;

//import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import java.util.HashMap;
//import java.util.Map;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@Feature("User Feature")
public class UserTest {
	
	@Story("should Be Able To Registrer")
	@Test(description="should Be Able To Registrer")
		public void shouldBeAbleToRegistrer ()  {
		
		User user =UserSteps.generateUser();
		Response response = UserApi.registrer(user);
		  		
		User retrunedUser = response.body().as(User.class);
		
		assertThat(response.statusCode(), equalTo(201));
		assertThat(retrunedUser.getFirstName(), equalTo(user.getFirstName()));
	
	} 
	
	// cas de test negative
	@Story("should Be Able To Registrer With The Same Email")
	@Test(description="should Be Able To Registrer With The Same Email")
		public void shouldBeAbleToRegistrerWithTheSameEmail () {
		
		User user =UserSteps.getRegisteredUser();
		Response response = UserApi.registrer(user);
		
		Error returnedError = response.body().as(Error.class);
		assertThat(response.statusCode(), equalTo(400));
		assertThat(returnedError.getMessage(), equalTo(errorMessages.EMAIL_IS_ALREADY_REGISTERED));
	
	}

	
		// cas de test login positive
	@Story("should Be Able To Login")
	@Test(description ="should Be Able To Login")
		public void shouldBeAbleToLogin() {
		
		User user =UserSteps.getRegisteredUser();
		User loginData = new User(user.getEmail(),user.getPassword());
		
		Response response =UserApi.login(loginData);
		User retrunedUser = response.body().as(User.class);
		assertThat(response.statusCode(), equalTo(200));
		assertThat(retrunedUser.getFirstName(), equalTo(user.getFirstName()));
		assertThat(retrunedUser.getAccessToken(), not(equalTo(null)));
		

		}
	
			//cas negatif
	@Story("should Not Be Able To Login If The Password Is Not Correct")
	@Test(description ="should Not Be Able To Login If The Password Is Not Correct")
		public void shouldNotBeAbleToLoginIfThePasswordIsNotCorrect () {
		
		User user =UserSteps.getRegisteredUser();
		User loginData = new User(user.getEmail(),"testres");
		
		Response response =UserApi.login(loginData);
		
		Error returnedError = response.body().as(Error.class);
		assertThat(response.statusCode(), equalTo(400));
		assertThat(returnedError.getMessage(), equalTo(errorMessages.EMAIL_OR_PASSWORD_IS_WRONG));
		
	}
			
}
