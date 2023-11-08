package steps;

import com.github.javafaker.Faker;

import Apis.UserApi;
import TODO.TestCases.Models.User;
import io.restassured.response.Response;

public class UserSteps {
	
	public static User generateUser() {
	
	Faker faker = new Faker();
	String firstName = 	faker.name().firstName();
	String lastName =	faker.name().lastName();
	String email =		faker.internet().emailAddress();
	//String password=	faker.internet().password()	;
	String password = ("test123r");
	
	return new User (email,password,firstName,lastName);
	
	}
	
	public static User getRegisteredUser() {
		User user =generateUser();
		UserApi.registrer(user);
		return user;
		
	}
	
	public static String getUserToken() {
		
		User user =generateUser();
		//register a new user et envoyer son token
		Response response= UserApi.registrer(user);
		return response.body().path("access_token");
		
	}
	
	
}
