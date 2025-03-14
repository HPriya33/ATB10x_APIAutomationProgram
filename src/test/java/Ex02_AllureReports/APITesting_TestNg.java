package Ex02_AllureReports;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_TestNg {
    @Test
    public void Test_Postive_01()

    {
        RestAssured
                .given()
            .baseUri("https://api.zippopotam.us")
            .basePath("/IN/110048")
            .when()
            .get()
            .then()
            .log().all().statusCode(200);
    }
    public void Test_Negative_02()
    {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/-1")
                .when().get().then().log().all().statusCode(200);
    }
   // public static void main(String[] args) {

  //  }
}
