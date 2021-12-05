package adapters;

import io.restassured.response.ValidatableResponse;
import models.Project;

public class ProjectsAdapter extends BaseAdapter {

    public static final String URL = "v1/project";

    public ValidatableResponse post(Project project) {
        return post(URL, converter.toJson(project));
    }

    public ValidatableResponse get() {
        return get(URL);
    }

    public ValidatableResponse getSingle(String projectCode) {
        return get(String.format("%s/%s", URL, projectCode));
    }
}
