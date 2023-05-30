package com.restful.booker.bookerinfo;

import com.restful.booker.model.BookerPojo;
import com.restful.booker.testbase.TestBase;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookerPostTest extends TestBase {

    static String firstname = "Jim99" ;
    static String lastname = "Brown";
    static int totalprice = 111;
    static boolean depositpaid = true;


    @Test
    public void createUser() {

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

        given()
                .contentType("application/json")
                .body(bookerPojo)
                .log().all()
                .when()
                .post("/booking")
                .then().log().all().statusCode(200);


    }
}


