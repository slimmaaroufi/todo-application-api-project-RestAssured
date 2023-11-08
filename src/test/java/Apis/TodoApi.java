package Apis;

import static io.restassured.RestAssured.given;

import TODO.TestCases.Models.Todo;
import base.Specs;
import data.route;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TodoApi {
	
	public static Response addTodo (Todo todo,String token ) {
		
		return given()
							.spec(Specs.getRequestSpecs())
							.auth().oauth2(token)
							.body(todo)
			.when()
							.post(route.TODOS_ROUTE)

			.then()
							.log().all()
							.extract().response();
		
	}
	
	public static Response getTodo(String token,String taskID) {
		
		return given()
				.spec(Specs.getRequestSpecs())
				.auth().oauth2(token)
				
		.when()
				.get(route.TODOS_ROUTE +"/" + taskID)
			
		.then()
				.log().all()
				.extract().response();	
	}
	
	
	public static Response deleteTodo(String token,String taskID) {
		
		return given()
				.spec(Specs.getRequestSpecs())
				.auth().oauth2(token)
					
		.when()
				.delete(route.TODOS_ROUTE +"/" + taskID)
			
		.then()
				.log().all()
				.extract().response();	
		
		
	}

}
