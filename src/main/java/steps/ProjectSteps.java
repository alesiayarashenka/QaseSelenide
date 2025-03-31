package steps;

import io.qameta.allure.Step;
import objects.Project;
import pages.NewProjectModalPage;
import pages.ProjectsListPage;

public class ProjectSteps extends BaseSteps {
    private ProjectsListPage projectsListPage;
    private NewProjectModalPage newProjectModalPage;

    public ProjectSteps() {
        projectsListPage = new ProjectsListPage();
        newProjectModalPage = new NewProjectModalPage();
    }

    @Step("open projects list page")
    public void openProjectsListPage(String url) {
        projectsListPage.openProjectList(url);
        projectsListPage.isOpened();
    }

    @Step("fill details in form to create new project")
    public void createNewProject(Project project) {
        projectsListPage.clickNewProjectButton();
        newProjectModalPage.fillProjectForm(project);
        projectsListPage.isOpened();
    }
}
