package org.acme.experiment;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class FAQResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/ask")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

}