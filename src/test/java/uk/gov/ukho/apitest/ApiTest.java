package uk.gov.ukho.apitest;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    private final String API_BASE = "https://jsonplaceholder.typicode.com";

    @Test
    public void WhenCallEndpointThenSuccessStatusReturned() {
        given()

        .when()
            .get(API_BASE + "/posts")

        .then()
            .statusCode(200);
    }
}
