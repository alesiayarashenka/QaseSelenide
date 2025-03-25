package tests;

import objects.Project;
import objects.TestCase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class CaseTest extends BaseTest {

    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void createTestCaseTest() {
        Project project = new Project();
        project.setProjectName("project" + random.nextInt(10));
        project.setProjectCode("code" + random.nextInt(10));
        project.setProjectDescription("nothing");

        TestCase testCase = new TestCase();
        testCase.setCaseTitle("Authorization");
        testCase.setCaseDescription("We authorized on page http://example.com/login");
        testCase.setCasePreConditions("open http://example.com/login");
        testCase.setCasePostConditions("sign out from http://example.com/login");
        testCase.setCaseBehavior("Positive");
        testCase.setCaseAutomationStatus("Automated");
        testCase.setCasePriority("High");
        testCase.setCaseLayer("API");
        testCase.setCaseSeverity("Critical");
        testCase.setCaseStatus("Actual");
        testCase.setCaseTag("Example tag");
        testCase.setCaseType("Functional");

        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectSteps.
                createNewProject(project);
        projectSteps.
                openProjectsListPage(PROJECT_LIST_URL);
        testCaseSteps.
                createNewTestCase(project, testCase);
        testCaseSteps.
                closeTestCaseForm();
        softAssert.assertEquals(testCaseListPage.getExistTestCaseField(project.getProjectCode().toUpperCase()), project.getProjectCode().toUpperCase() + "-1");
        softAssert.assertEquals(testCaseListPage.getExistTestCaseField(testCase.getCaseTitle()), testCase.getCaseTitle());
        softAssert.assertAll();
    }
}
