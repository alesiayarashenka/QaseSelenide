package steps;

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
}