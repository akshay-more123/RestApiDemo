package Auothintication;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import Pojo.AddPlace;
import Pojo.LocationClass;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import io.restassured.specification.RequestSpecification;

public class SpecBuilderClass {

	@Test
	 public void getData()
	 {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace ap = new AddPlace();
		  ap.setWebsite("https://rahulshettyacademy.com");
		  ap.setAddress("29, side layout, cohen 09");
		  ap.setAccuracy(50);
		  ap.setLanguage("English");
		  ap.setName("Magarpatta Villa");
		  ap.setPhone_number("9172462714");
		  List<String> list = new ArrayList<String>();
		  list.add("shoe park");
		  list.add("shop");
		  ap.setTypes(list);
		  
		  LocationClass l = new LocationClass();
		  l.setLat(-38.383494);
		  l.setLng(33.427362);
		  ap.setLocation(l);
		  
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		  .setContentType(ContentType.JSON).build();
		  
		   RequestSpecification response = given().spec(req).body(ap);
		   
		 ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				   
		  Response respons = response.when().post("/maps/api/place/add/json").then().spec(resSpec)
           .extract().response();
		  
		  String Res = respons.asString();
				            
		 
		  System.out.println(respons);
		  
		  System.out.println(respons);
		  
	 }
}
