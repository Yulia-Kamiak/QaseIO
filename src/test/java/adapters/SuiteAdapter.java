package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SuiteAdapter extends BaseAdapter {

    private static final String URI = "https://api.qase.io/v1/suite/";

    public QaseResponse<Suite> getByApi(int projectCode, int id, int expectedStatusCode) {
        return new Gson().fromJson(super.get(projectCode, URI, id, expectedStatusCode), new TypeToken<QaseResponse<Suite>>() {
        }.getType());

    }

    public QaseResponse<Suite> createByApi(Suite suite, int expectedStatusCode) {
        return new Gson().fromJson(super.post(suite, (URI + suite.getProjectCode()), expectedStatusCode), new TypeToken<QaseResponse<Suite>>() {
        }.getType());

    }

    public QaseResponse<Suite> deleteByApi(int projectCode, int id, int expectedStatusCode) {
        return new Gson().fromJson(super.delete(projectCode, URI, id, expectedStatusCode), new TypeToken<QaseResponse<Suite>>() {
        }.getType());
    }

}
