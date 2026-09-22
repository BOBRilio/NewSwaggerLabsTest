package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APItests {
    public void apiTest(){
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Leanne Graham"))
                .body("email", equalTo("Sincere@april.biz"))
                .body("username", equalTo("Bret"));
    }

}
