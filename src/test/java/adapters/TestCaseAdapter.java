package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestCaseAdapter extends BaseAdapter {

    private static final String URI = "https://api.qase.io/v1/case/";

    public QaseResponse<TestCase> getByApi(int projectCode, int id, int expectedStatusCode) {
        return new Gson().fromJson(super.get(projectCode, URI, id, expectedStatusCode), new TypeToken<QaseResponse<TestCase>>() {
        }.getType());
    }

    public QaseResponse<TestCase> createByApi(TestCase testCase, int expectedStatusCode) {
        return new Gson().fromJson(super.post(testCase, (URI + testCase.getProjectCode()), expectedStatusCode), new TypeToken<QaseResponse<TestCase>>() {
        }.getType());
    }

    public QaseResponse<TestCase> deleteByApi(int projectCode, int id, int expectedStatusCode) {
        return new Gson().fromJson(super.delete(projectCode, URI, id, expectedStatusCode), new TypeToken<QaseResponse<TestCase>>() {
        }.getType());
    }

}
