package Auothintication;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.ApiClass;
import Pojo.GetCourse;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oauothintication_Class {

	@Test
	
	public void getAuothintication()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//Post Authontication
		//String[] ExpectTitle = {"Selenium Webdriver Java,Cypress,Protractor"};
		String res = given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust").log().all().when().post("/oauthapi/oauth2/resourceOwner/token")
		.asString();
		
		System.out.println(res);
		
		JsonPath js = new JsonPath(res);
		String tokenType = js.getString("access_token");
		System.out.println(tokenType);
		
		//Get Authontication
		
		GetCourse gc  = given().log().all().queryParam("access_token", tokenType).when()
				         .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				         .as(GetCourse.class);
		
		System.out.println(gc.getInstructor());
		System.out.println(gc.getUrl());
		System.out.println(gc.getLinkedIn());
		
		//get course name of api at 1st index
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		// if index is unknwon then (it is for api courses)
		List<ApiClass> title = gc.getCourses().getApi();
		
		for(int i = 0; i<title.size();i++)
		{
			if(title.get(i).getCourseTitle().equalsIgnoreCase("SoapUi webservices Testing"))
			{
				System.out.println(title.get(i).getPrice());
			}
					
		}
		
		// print all the coursename of webautomation course
		
		List<WebAutomation> webTitle = gc.getCourses().getWebAutomation();
		
		for(int j = 0; j<webTitle.size();j++)
		{
			System.out.println(webTitle.get(j).getCourseTitle());
			if(webTitle.get(j).getCourseTitle().equalsIgnoreCase("Selenium Webdriver Java"))
			{
				System.out.println(webTitle.get(j).getPrice());
			}
		}
		
		
		
		//compare array and arraylist with assertion
		
//		List<String> a = new ArrayList<String>();
//		for(int k = 0; k<webTitle.size();k++)
//		{
//			a.add(webTitle.get(k).getCourseTitle());
//		}
//		
//	List<String> ExpectedList =	Arrays.asList(ExpectTitle);
//	
//	Assert.assertTrue(equals(ExpectedList));
//		           
//
//		
	}
}
