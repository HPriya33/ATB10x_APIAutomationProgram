package EX06_PUTRequest;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PUT_Request {

        @Description("Verify the PUT Request for the Restful Booker APIs")
        @Test
        public void test_put_non_bdd () {

            String token = "f169230b870670f";
            String bookingid = "2097";

            String payloadPUT = "{\n" +
                    "    \"firstname\" : \"Priya\",\n" +
                    "    \"lastname\" : \"Hingmire\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : false,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2024-01-01\",\n" +
                    "        \"checkout\" : \"2024-01-01\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Lunch\"\n" +
                    "}";


            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("/booking/" + bookingid);
            requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.auth().basic("admin","password123");


            requestSpecification.cookie("token", token);
            requestSpecification.body(payloadPUT).log().all();

            Response response = requestSpecification.when().put();


            ValidatableResponse validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);



        }
    }
