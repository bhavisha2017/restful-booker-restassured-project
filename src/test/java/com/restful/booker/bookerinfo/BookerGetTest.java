package com.restful.booker.bookerinfo;

import com.restful.booker.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookerGetTest extends TestBase {

    //Singe User
    @Test
    public void getAllBookerInfo() {
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getBookingByFirstname()
    {
        Response response = given().
                contentType(ContentType.JSON)
                .queryParam("firstname","Jim99")
                .when()
                .get("/booking");
        response .then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void Test003()
    {
        Response response = given().
                contentType(ContentType.JSON)
                .queryParam("checkin","2014-03-13")
                .queryParam("checkout","2014-05-21")
                .when()
                .get("/booking");
        response .then().statusCode(200);
        response.prettyPrint();
    }



}
