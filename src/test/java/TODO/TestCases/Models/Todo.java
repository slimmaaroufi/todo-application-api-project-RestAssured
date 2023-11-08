package TODO.TestCases.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Todo {
	
	// utilise Non-default pour enlever les variables par défaults et surtout pour les types boolean
	//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	
	// pour enlever le probleme default value dans le type boolean on doit utilisé l'objet Boolean.
	//changer type primitif "boolean" par l'objet "Boolean"
	
	@JsonProperty("isCompleted")
	private Boolean isCompleted;
	
	@JsonProperty("_id")
	private String id;
	
	private String item;
	private String userID;
	private String createdAt;
	
	@JsonProperty("__v")
	private String v;
	
	
	public Todo () {
		
	}
	
	
// 1Constructeur	
	public Todo (String item,Boolean isCompleted) {
		this.item=item;
		this.isCompleted=isCompleted;
	}
// 2 constructeur	
	public Todo (String item) {
		this.item=item;
		
	}
	
	
	@JsonProperty("isCompleted")
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	
	@JsonProperty("isCompleted")
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	@JsonProperty("_id")
	public String getid() {
		return id;
	}
	
	@JsonProperty("_id")
	public void set_id(String id) {
		this.id = id;
	}
	
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	@JsonProperty("__v")
	
	public String getv() {
		return v;
	}
	
	@JsonProperty("__v")
	
	public void setv(String v) {
		this.v = v;
	}
		
}
