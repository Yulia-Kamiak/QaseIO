package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProjectAdapter extends BaseAdapter {

    private static final String URI = "https://api.qase.io/v1/project/";

    public QaseResponse<Project> getByApi(int projectCode, int expectedStatusCode) {
        return new Gson().fromJson(super.get(projectCode, URI, expectedStatusCode), new TypeToken<QaseResponse<Project>>() {
        }.getType());
    }

    public QaseResponse<Project> createByApi(Project project, int expectedStatusCode) {
        return new Gson().fromJson(super.post(project, URI, expectedStatusCode), new TypeToken<QaseResponse<Project>>() {
        }.getType());
    }

    public QaseResponse<Project> deleteByApi(int projectCode, int expectedStatusCode) {
        return new Gson().fromJson(super.delete(projectCode, URI, expectedStatusCode), new TypeToken<QaseResponse<Project>>() {
        }.getType());
    }
}
