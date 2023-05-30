package com.restful.booker.bookerinfo;

import com.restful.booker.model.BookerPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookerCRUDTest extends TestBase {
    static String firstname = "Jim99";
    static String lastname = "Brown";
    static int totalprice = 111;
    static boolean depositpaid = true;
    static int bookingId;
    

    //CREATE USER
    @Test
    public void test001(){
    HashMap<String, String> bookingdates1 = new HashMap<>();
        bookingdates1.put("checkin","2018-01-01");
        bookingdates1.put("checkout","2018-01-01");

    BookerPojo bookerPojo = new BookerPojo();
        bookerPojo.setFirstname(firstname);
        bookerPojo.setLastname(lastname);
        bookerPojo.setTotalprice(totalprice);
        bookerPojo.setDepositpaid(depositpaid);
        bookerPojo.setBookingdates(bookingdates1);
        bookerPojo.setAdditionalneeds("");

        ValidatableResponse response = given()
                .contentType("application/json")
                .body(bookerPojo)
                .log().all()
                .when()
                .post("/booking")
                .then().log().all().statusCode(200);

       bookingId = response.extract().path("bookingid");
        System.out.println(bookingId);



}
//GET USER
    @Test
    public void test002()
    {
        Response response = given().
                contentType(ContentType.JSON)
                .queryParam("firstname","Jim99")
                .when()
                .get("/booking");
        response .then().statusCode(200);
        response.prettyPrint();

    }

//    UPDATE USER
    @Test
    public void test003()
    {

        HashMap<String, String> bookingdates1 = new HashMap<>();
        bookingdates1.put("checkin", "2019-02-01");
        bookingdates1.put("checkout", "2019-02-01");

        BookerPojo bookerPojo = new BookerPojo();
        bookerPojo.setFirstname(firstname);
        bookerPojo.setLastname(lastname);
        bookerPojo.setTotalprice(totalprice);
        bookerPojo.setDepositpaid(depositpaid);
        bookerPojo.setBookingdates(bookingdates1);
        bookerPojo.setAdditionalneeds("ghjg");


                given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .body(bookerPojo)
                .log().all()
                .when()
                .put("/booking/"+bookingId)
                        .then()
                        .log().all().statusCode(200);
    }

//    DELETE USER
    @Test
    public void test006()
    {

        given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").
                header("Cookie","token="+token).
                log().all().
                when().
                delete("/booking/"+bookingId).then().log().all().statusCode(201);

    }
}
