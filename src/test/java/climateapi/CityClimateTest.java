package climateapi;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CityClimateTest {
	
  //@Test
//  public void getCityClimateDetails() {
//	  RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
//	  RequestSpecification httpReq = RestAssured.given();
//	  
////	  Response resp = httpReq.request(Method.GET, "/Kolkata");
//	  
//	  Response resp = httpReq.get("/Kolkata");
//	  int statusCode = resp.getStatusCode();
//	  System.out.println("The status code is: " + statusCode);
//	  System.out.println(resp.getStatusLine() + " is the status line from the server...");
//	  String response = resp.body().asString();
//	  System.out.println("The response rendered from the server: " + response);
//	  Assert.assertEquals(statusCode, 200);
//	  
//	  Headers headers = resp.headers();
//	  for(Header h : headers) {
//		  System.out.println("Header name: " + h.getName() + " and Header Value is: " + h.getValue());
//	  }
//  }
	
	@BeforeMethod
	  public void setup() {
	      RestAssured.baseURI = "http://localhost:3000/stocks";
	  }
	
  @Test
  public void getOperation() {

//      RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

      Response response = RestAssured
              .given()
              .log().all()
              .when()
              .get()
              .then()
              .extract()
              .response();

      System.out.println("Response Body:\n" + response.asPrettyString());
      Assert.assertEquals(response.getStatusCode(), 200);
  } 
  
  @Test(priority = 1)
  public void postOperation() {

	  String requestBody = "{\n" +
	            "  \"id\": \"4\",\n" +
	            "  \"name\": \"TCS\",\n" +
	            "  \"price\": 6850\n" +
	            "}";

      Response response =
              RestAssured
              .given()
              .header("Content-Type", "application/json")
              .body(requestBody)
              .when()
              .post()
              .then()
              .extract()
              .response();

      System.out.println("POST Response:\n" + response.asPrettyString());
      Assert.assertEquals(response.getStatusCode(), 201);
  }
//  
//  @Test(priority = 2)
//  public void patchOperation() {
//
//      //RestAssured.baseURI = "http://localhost:3000";
//
//      String requestBody = "{ \"market\": null }";
//
//      Response response =
//              RestAssured
//              .given()
//              .header("Content-Type", "application/json")
//              .body(requestBody)
//              .when()
//              .patch("/stocks/101")
//              .then()
//              .extract()
//              .response();
//
//      Assert.assertEquals(response.getStatusCode(), 200);
//      System.out.println("PATCH Response:\n" + response.asPrettyString());
//  }
//  
//  @Test(priority = 3)
//  public void deleteOperation() {
//
//      //RestAssured.baseURI = "http://localhost:3000";
//
//      Response response =
//              RestAssured
//              .given()
//              .when()
//              .delete("/stocks/101")
//              .then()
//              .extract()
//              .response();
//
//      Assert.assertEquals(response.getStatusCode(), 200);
//      System.out.println("DELETE Response:\n" + response.asPrettyString());
//  }
}