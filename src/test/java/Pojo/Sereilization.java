package Pojo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Sereilization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  RestAssured.baseURI = "\"https://rahulshettyacademy.com";
	  
	  String response = given().queryParam("key", "qaclick123").body("").when()
			            .post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
			            .extract().asString();
			            
	}

}
