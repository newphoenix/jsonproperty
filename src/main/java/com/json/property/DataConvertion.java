package com.json.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DataConvertion {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	
		//Api returning data
		//1. camel case the normal situation
		String data = """
				{
				  "firstName":"John",
				  "lastName": "Smith",
				  "age": 25
				}
				""";
		
		//2. upper camel case 
//		String data = """
//				{
//				  "FirstName":"John",
//				  "LastName": "Smith",
//				  "Age": 25
//				}
//				""";
		
		//3. snake case 
//		String data = """
//				{
//				  "first_name":"John",
//				  "last_name": "Smith",
//				  "age": 25
//				}
//				""";
		
		//4. upper snake case 
//		String data = """
//				{
//				  "FIRST_NAME":"John",
//				  "LAST_NAME": "Smith",
//				  "AGE": 25
//				}
//				""";
		
		//5. kebab case 
//		String data = """
//				{
//				  "first-name":"John",
//				  "last-name": "Smith",
//				  "age": 25
//				}
//				""";
		
		
		User user = (new ObjectMapper()).readValue(data,User.class);
		
		System.out.println(user);

	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	// @JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class) // used in case 2
    //@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // used in case 3
	//@JsonNaming(PropertyNamingStrategies.UpperSnakeCaseStrategy.class) // used in case 4
	//@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class) // used in case 5
	private static class User{
		private String firstName;
		private String lastName;
		private Integer age;
	}

}
