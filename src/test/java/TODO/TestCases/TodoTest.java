package TODO.TestCases;
//import org.json.JSONObject;
import org.testng.annotations.Test;

import Apis.TodoApi;
import TODO.TestCases.Models.Todo;
//import TODO.TestCases.Models.User;
import data.errorMessages;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

//import com.aventstack.extentreports.model.Log;

//import io.restassured.http.ContentType;
//import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import steps.TodoSteps;
import steps.UserSteps;

//import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import java.util.HashMap;
//import java.util.Map;
//import static io.restassured.matcher.RestAssuredMatchers.*;


@Feature("Todo Feature")
public class TodoTest {
	
	
	//cas postif todo
	@Story("should Be Able To Add Todo")
	@Test(description="should Be Able To Add Todo")
		public void shouldBeAbleToAddTodo() {
		
		String token =UserSteps.getUserToken();
		Todo todo =TodoSteps.generateTodo();
		
		Response response =TodoApi.addTodo(todo, token);
		
		Todo retrunedTodo = response.body().as(Todo.class);
		assertThat(response.statusCode(), equalTo(201));
		assertThat(retrunedTodo.getItem(), equalTo(todo.getItem()));
		assertThat(retrunedTodo.getIsCompleted(), equalTo(todo.getIsCompleted()));
		//main m = new main();
		//m.setStudents(new Student[5]);
		//m.getStudents()[0] = new Student(1,"Ahmed" ,"Maroc","1234567890", new String[] {"java", "Selenium"});
		//m.getStudents()[1] = new Student();
		//m.getStudents()[1].setId(2);
	
	}
		
		@Story("should Not Be Able Todo If Is Completed Is Missing")
		@Test(description="should Not Be Able Todo If Is Completed Is Missing")
		public void shouldNotBeAbleTodoIfIsCompletedIsMissing() {
		
		Todo todo =new Todo("Learn Postman");
		String token =UserSteps.getUserToken();
		Response response =TodoApi.addTodo(todo, token);
		
		Error returnedError = response.body().as(Error.class);
		
		assertThat(response.statusCode(), equalTo(400));
		assertThat(returnedError.getMessage(), equalTo(errorMessages.IS_COMPLETED_IS_REQUIRED));
		
		}
		
		@Story("should Be Able To Get A Todo By ID")
		@Test(description="should Be Able To Get A Todo By ID")
		public void shouldBeAbleToGetATodoByID() {
		
		String token =UserSteps.getUserToken();
		Todo todo =TodoSteps.generateTodo(); 	
		String todoID =TodoSteps.getTodoID(todo,token);
		Response response =TodoApi.getTodo(token, todoID);
		Todo retrunedTodo = response.body().as(Todo.class);
		
		assertThat(response.statusCode(), equalTo(200));
		assertThat(retrunedTodo.getIsCompleted(), equalTo(false));
		assertThat(retrunedTodo.getItem(), equalTo(todo.getItem()));
					
		}		
		
		@Story("should Be Able To Delete A Todo")
		@Test(description="should Be Able To Delete A Todo")
		public void shouldBeAbleToDeleteATodo() {
		
			
		String token =UserSteps.getUserToken();
		Todo todo =TodoSteps.generateTodo(); 	
		String todoID =TodoSteps.getTodoID(todo,token);
		Response response =TodoApi.deleteTodo(token, todoID);
		
		Todo retrunedTodo = response.body().as(Todo.class);
		assertThat(response.statusCode(), equalTo(200));
		assertThat(retrunedTodo.getIsCompleted(), equalTo(false));
		assertThat(retrunedTodo.getItem(), equalTo(todo.getItem()));
			
		}
			
			
}		
