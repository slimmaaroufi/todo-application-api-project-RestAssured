package base;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specs {
	
	//lire valeur d'environnement
	public static String getEnv() {
		String env= System.getProperty("env","PRODUCTION");
		String baseURL;
		switch (env) {
		
		case "PRODUCTION":
			baseURL="https://todo.qacart.com";
			break;
		case "LOCAL":
			baseURL="https://localhost:8080";
			break;
		default:
			throw new RuntimeException("Environment is not supported");
			
		}
		return baseURL;
	}
	
	
	public static RequestSpecification getRequestSpecs() {
		
		//System.getProperty("env");
		return given()
				.baseUri(getEnv())
				.contentType(ContentType.JSON)
				.log().all();
		
	}
	
}
