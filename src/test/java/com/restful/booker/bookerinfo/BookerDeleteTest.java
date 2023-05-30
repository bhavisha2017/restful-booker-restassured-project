package com.restful.booker.bookerinfo;

import com.restful.booker.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookerDeleteTest extends TestBase {

    @Test
    public void deleteBookerWithParameter() {

        given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                header("Cookie","token="+token).
                log().all().
                when().
                delete("/booking/253").then().log().all().statusCode(201);

    }

}
