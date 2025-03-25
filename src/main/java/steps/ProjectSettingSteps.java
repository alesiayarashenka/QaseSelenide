package steps;

import io.qameta.allure.Step;
import objects.Project;
import pages.*;

public class ProjectSettingSteps extends BaseSteps {
    private ProjectsListPage projectsListPage;
    private ProjectSettingsPage projectSettingsPage;
    private DeleteProjectModalPage deleteProjectModalPage;
    private TestCaseListPage testCaseListPage;

    public ProjectSettingSteps() {
        projectsListPage = new ProjectsListPage();
        projectSettingsPage = new ProjectSettingsPage();
        deleteProjectModalPage = new DeleteProjectModalPage();
        testCaseListPage = new TestCaseListPage();
    }

    @Step("Delete new project from projects list")
    public void deleteNewProject(String url, Project project) {
        projectsListPage.openProjectList(url);
        projectsListPage.directToCaseForm(project);
        testCaseListPage.isOpened();
        projectSettingsPage.clickOnSettingsButton();
        projectSettingsPage.isOpened();
        projectSettingsPage.clickDeleteProjectButton();
        deleteProjectModalPage.clickDeleteProjectButtonOnPopUp();
        projectsListPage.isOpened();
    }
}