package steps;

import io.qameta.allure.Step;
import objects.Project;
import objects.TestCase;
import pages.NewCaseTestModalPage;
import pages.ProjectsListPage;
import pages.TestCaseListPage;

public class TestCaseSteps extends BaseSteps {

    private ProjectsListPage projectsListPage;
    private NewCaseTestModalPage newCaseTestModalPage;
    private TestCaseListPage testCaseListPage;

    public TestCaseSteps() {
        projectsListPage = new ProjectsListPage();
        newCaseTestModalPage = new NewCaseTestModalPage();
        testCaseListPage = new TestCaseListPage();
    }

    @Step("fill details in form to create new test case")
    public void createNewTestCase(String code, String name,TestCase testCase) {
        projectsListPage.directToCaseForm(code, name);
        testCaseListPage.openCaseTestForm();
        newCaseTestModalPage.fillTestCaseForm(testCase);
        testCaseListPage.isOpened();
    }

    @Step("close test case form")
    public void closeTestCaseForm() {
        testCaseListPage.closeCaseTestForm();
        testCaseListPage.isOpened();
    }
}
