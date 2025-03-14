package EX05_PatchRequest;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Patch_Request {
    @Description("Verify the Patch Request for the Restful Booker APIs")
    @Test
    public void test_patch_non_bdd() {


        String token = "f169230b870670f";
        String bookingid = "1577";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Priyanka\",\n" +
                "    \"lastname\" : \"Test\"\n" +
                "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
    }
}
