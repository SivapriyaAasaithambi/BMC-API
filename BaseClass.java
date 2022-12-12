package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	static RequestSpecification reqSpec;
	public static Response response;
	
	public static void addHeader(String key, String value) {
		reqSpec=RestAssured.given().header(key,value);
	}
	
	public void queryParam(String key, String value) {
		reqSpec=reqSpec.queryParam(key, value);
		
	}
	
	public void pathParam(String key, String value) {
		reqSpec=reqSpec.pathParam(key, value);
		
	}
	
	public void addBody(Object body) {
		reqSpec=reqSpec.body(body);
	}
	
	 public void addHeaders(Headers headers) {
	 reqSpec=RestAssured.given().headers(headers);
	 
	 }
	 
	
	public static Response requestType(String type,String endpoint) {
		switch(type) {
		case "GET":
			response=reqSpec.get(endpoint);
			break;
			
		case "POST":
			response=reqSpec.get(endpoint);
			break;
			
		case "PUT":
			response=reqSpec.get(endpoint);
			break;
			
		case "DELETE":
			response=reqSpec.get(endpoint);
			break;
			
			default:
				break;
		
		}
		return response;
		
	}
	
	public String getBodyAsString(Response response) {
		String asString = response.asString();
		return asString;

	}
	
	public int getStatusCode(Response response) {
		int statusCose = response.getStatusCode();
		return statusCose;

	}
	
	
	public String getBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
	
	public static void basicAuth(String username, String password) {
		reqSpec=reqSpec.auth().preemptive().basic(username, password);

	}
	
	public String getPropertyValue(String key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Endpoints\\Endpoints.properties "));
		Object object = properties.get(key);
		String value=(String) object;
		return value;
		

	}
	

}
