package Apis;

import static io.restassured.RestAssured.given;


import  TODO.TestCases.Models.User;
import base.Specs;
import data.route;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserApi {

	
	public static Response registrer(User user) {
		
		return  given()
				.spec(Specs.getRequestSpecs())
				.body(user)	
		.when()
				.post(route.REGISTER_ROUTE)
			
		.then()
				.log().all()
				.extract().response();
		
	}
	
	
	public static Response login (User user) {
		
		return  given()
				.spec(Specs.getRequestSpecs())
				.body(user)	
		.when()
				.post(route.LOGIN_ROUTE)
			
		.then()
				.log().all()
				.extract().response();
		
		
	}
	
	
	
}
