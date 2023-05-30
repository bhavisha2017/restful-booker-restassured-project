package com.restful.booker.testbase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;



public class TestBase {

    public String token;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
//        RestAssured.basePath = "/booking";
    }

    @Before
    public  void authorisation(){

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);

        token = response.jsonPath().getString("token");

    }
}
