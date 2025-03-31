package tests;

import com.codeborne.selenide.Configuration;
import objects.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.DeleteProjectModalPage;
import pages.ProjectSettingsPage;
import pages.ProjectsListPage;
import pages.TestCaseListPage;
import steps.ProjectSettingSteps;
import steps.TestCaseSteps;
import steps.LoginSteps;
import steps.ProjectSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    ProjectsListPage projectsListPage;
    protected LoginSteps loginSteps;
    protected ProjectSteps projectSteps;
    protected TestCaseSteps testCaseSteps;
    protected TestCaseListPage testCaseListPage;
    protected ProjectSettingSteps projectSettingSteps;
    protected ProjectSettingsPage projectSettingsPage;
    protected DeleteProjectModalPage deleteProjectModalPage;
    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String PROJECT_LIST_URL = PropertyReader.getProperty("projectListUrl");

    public void initPages() {
        loginSteps = new LoginSteps();
        projectSteps = new ProjectSteps();
        testCaseSteps = new TestCaseSteps();
        projectsListPage = new ProjectsListPage();
        testCaseListPage = new TestCaseListPage();
        projectSettingSteps = new ProjectSettingSteps();
        projectSettingsPage = new ProjectSettingsPage();
        deleteProjectModalPage = new DeleteProjectModalPage();
    }

    @BeforeMethod
    public void initTest() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }

    @AfterMethod(alwaysRun = true)
    public void deleteNewProject() {
        projectsListPage.openProjectList(PROJECT_LIST_URL);
        projectsListPage.directToCaseForm("CODE","project");
        testCaseListPage.isOpened();
        projectSettingsPage.clickOnSettingsButton();
        projectSettingsPage.isOpened();
        projectSettingsPage.clickDeleteProjectButton();
        deleteProjectModalPage.clickDeleteProjectButtonOnPopUp();
        projectsListPage.isOpened();
        Assert.assertEquals(projectsListPage.projectIsPresentOnList("project"), false);
    }
}