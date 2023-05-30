package com.restful.booker.bookerinfo;

import com.restful.booker.model.BookerPojo;
import com.restful.booker.testbase.TestBase;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookerPutTest extends TestBase {

    static String firstname = "Jim11";
    static String lastname = "Brown22";
    static int totalprice = 100;
    static boolean depositpaid = true;

    @Test
    public void updateUser() {

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
                .put("/booking/253")
                .then().log().all().statusCode(200);
    }
}