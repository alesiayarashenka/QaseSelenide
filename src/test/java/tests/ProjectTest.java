package tests;

import objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void createProjectTest() {
        Project project = new Project();
        project.setProjectName("project");
        project.setProjectCode("code");
        project.setProjectDescription("nothing");
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectSteps.
                createNewProject(project);
        projectSteps.
                openProjectsListPage(PROJECT_LIST_URL);
        Assert.assertEquals(projectsListPage.getExistProjectName(project.getProjectName()), project.getProjectName());
    }
}
