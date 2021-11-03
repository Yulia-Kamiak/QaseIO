package models;

public class TestCaseFactory {

    public static TestCase get() {
        return new TestCase("Check that test case can be created", "Draft", "Test cases without suite",
                "Major","High", "Smoke", "API", "No", "Not set",
                "Not set", "Automated");
    }
}
