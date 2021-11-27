package adapters;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import static io.restassured.RestAssured.given;

@Log4j2
public abstract class BaseAdapter {

    private static final String TOKEN = "ffd0a24db5e9091651f225056c513714f56332af";

    protected String get(int code, String uri, int expectedStatusCode) {
        log.info(uri + code);
        return given().
                header("Content-Type", "application/json").
                header("token", TOKEN).
                get(uri + code).
                then().
                log().all().
                statusCode(expectedStatusCode).
                extract().
                body().
                asString();
    }

    protected String get(int projectCode, String uri, int id, int expectedStatusCode) {
        log.info(uri + projectCode + "/" + id);
        return given().
                header("Content-Type", "application/json").
                header("token", TOKEN).
                get(uri + projectCode + "/" + id).
                then().
                log().all().
                statusCode(expectedStatusCode)
                .extract()
                .body().asString();
    }

    protected String post(Object model, String uri, int statusCode) {
        log.info(model);
        log.info(uri);
        return given().
                header("Content-Type", "application/json").
                header("token", TOKEN).
                body(new Gson().toJson(model)).
                when().
                post(uri)
                .then().
                        log().all().
                        statusCode(statusCode)
                .extract()
                .asString();
    }

    protected String delete(int code, String uri, int expectedStatusCode) {
        return given().
                header("token", TOKEN).
                when().
                delete(uri + code).
                then().
                log().all().
                statusCode(expectedStatusCode).
                extract().
                asString();
    }

    protected String delete(int code, String uri, int id, int expectedStatusCode) {
        return given().
                header("Accept", "application/json").
                header("token", TOKEN).
                when().
                delete(uri + code + "/" + id).
                then().
                log().all().
                statusCode(expectedStatusCode).
                extract().
                asString();
    }

}
