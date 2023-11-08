package steps;

import com.github.javafaker.Faker;

import Apis.TodoApi;
import  TODO.TestCases.Models.Todo;
import io.restassured.response.Response;

public class TodoSteps {

	public static Todo generateTodo() {
		
		Faker faker = new Faker();
		String item =faker.book().title();
		boolean isCompleted = false;
	return new Todo(item,isCompleted);
		
		
	}
	
	public static String getTodoID(Todo todo,String token) {
		
		
		Response response = TodoApi.addTodo(todo, token);
		return response.body().path("_id");
	}
	
	
	
	
}
