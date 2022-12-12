package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CreateBooking extends BaseClass{
	//static String token;
	
	/*
	 * @Test(priority=-5) public void createToken() throws
	 * FileNotFoundException,IOException { //add header addHeader("Content-Type",
	 * "application/json");
	 * 
	 * //Basic Auth //basicAuth("admin", "password123");
	 * 
	 * 
	 * addBody("{\r\n" + "    \"username\" : \"admin\",\r\n" +
	 * "    \"password\" : \"password123\"\r\n" + "}");
	 * 
	 * 
	 * Response response= requestType("POST",getPropertyValue("CreateToken"));
	 * 
	 * int statusCode = getStatusCode(response); System.out.println(statusCode);
	 * 
	 * String bodyAsPrettyString = getBodyAsPrettyString(response);
	 * System.out.println(bodyAsPrettyString);
	 * 
	 * 
	 * //Assert.assertEquals("token","abc123", "verify the token");
	 * //Assert.assertEquals("token","verify the token" );
	 * 
	 * }
	 */
	 

  @Test(priority=-3)
	
	public void create() throws FileNotFoundException, IOException {
		addHeader("Content-Type", "application/json");
		addBody("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		
		Response response= requestType("POST",getPropertyValue("CreateBooking"));
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		String bodyAsPrettyString = getBodyAsPrettyString(response);
		System.out.println(bodyAsPrettyString);
		
		

	}
  
  @Test(priority=-1)
	
	public void read() throws FileNotFoundException, IOException {

		addHeader("Content-Type", "application/json");
      //pathParam("id", "16758");
      
      Response response = requestType("GET", getPropertyValue("GetBooking"));
      int statusCode = getStatusCode(response);
      System.out.println(statusCode);
		
      String bodyAsPrettyString = getBodyAsPrettyString(response);
      System.out.println(bodyAsPrettyString);
		
	}
	
  @Test
	public void update() throws FileNotFoundException, IOException {
		
		List<Header> header = new ArrayList<>();
	    Header h1=new Header("Content-Type","application/json"); 
	    Header h2=new Header("Accept","application/json"); 
	    Header h3=new Header("Cookie","token=abc123"); 
	    
	    header.add(h1);
	    header.add(h2);
	    header.add(h3);
	    
	    Headers headers=new Headers(header);
	    addHeaders(headers);
	    
	    addBody("{\r\n"
	    		+ "    \"firstname\" : \"James\",\r\n"
	    		+ "    \"lastname\" : \"Brown\",\r\n"
	    		+ "    \"totalprice\" : 111,\r\n"
	    		+ "    \"depositpaid\" : true,\r\n"
	    		+ "    \"bookingdates\" : {\r\n"
	    		+ "        \"checkin\" : \"2018-01-01\",\r\n"
	    		+ "        \"checkout\" : \"2019-01-01\"\r\n"
	    		+ "    },\r\n"
	    		+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	    		+ "}");
	    
       response= requestType("PUT",getPropertyValue("UpdateBooking"));
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		String bodyAsPrettyString = getBodyAsPrettyString(response);
		System.out.println(bodyAsPrettyString);
	    
      
	}
  
  @Test(priority=3)
  
  public void remove() throws FileNotFoundException, IOException {
	
	  addHeader("Content-Type", "application/json");
	  
	  response= requestType("DELETE",getPropertyValue("DeleteBooking"));

	  int statusCode = getStatusCode(response);
	  System.out.println(statusCode);
		
	  String bodyAsPrettyString = getBodyAsPrettyString(response);
	  System.out.println(bodyAsPrettyString);
}
	
}
