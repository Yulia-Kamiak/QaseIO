package adapters;

import io.restassured.response.ValidatableResponse;
import models.Project;
import models.TestSuite;

public class TestSuiteAdapter extends BaseAdapter {

    public static final String URL = "v1/suite";


    public ValidatableResponse post(Project project, TestSuite testSuite) {
        return
                post(String.format("%s/%s", URL, project.getCode()), converter.toJson(testSuite));
    }

    public ValidatableResponse getSingle(String projectCode, int id) {
        return
                get(String.format("%s/%s/%s", URL, projectCode, id));
    }

    public ValidatableResponse getAll(String projectCode) {
        return
                get(String.format("%s/%s", URL, projectCode));
    }

    public ValidatableResponse patch(Project project, int id, TestSuite testSuite) {
        return
                patch(String.format("%s/%s/%s", URL, project.getCode(), id), converter.toJson(testSuite));
    }

    public ValidatableResponse delete(String projectCode, int id) {
        return
                delete(String.format("%s/%s/%s", URL, projectCode, id));
    }
}