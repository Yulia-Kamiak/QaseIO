package adapters;

import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    public static final String token = System.getenv().getOrDefault("token", PropertyReader.getProperty("token"));
    public static final String URLAPI = System.getenv().getOrDefault("urlApi", PropertyReader.getProperty("urlApi"));
    Gson converter = new Gson();

    public ValidatableResponse get(String urli) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .when()
                        .get(URLAPI + urli)
                        .then()
                        .log().all();
    }

    public ValidatableResponse post(String urli, String body) {
        return given()
                .header("Token", token)
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .when()
                .post(URLAPI + urli)
                .then()
                .log().all();
    }

    public ValidatableResponse patch(String urli, String body) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .log().all()
                        .when()
                        .patch(URLAPI + urli)
                        .then()
                        .log().all();
    }

    public ValidatableResponse delete(String urli) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .log().all()
                        .when()
                        .delete(URLAPI + urli)
                        .then()
                        .log().all();
    }
}
