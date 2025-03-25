package tests;

import objects.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ProjectTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createProjectTest() {
        Project project = new Project();
        project.setProjectName("project" + random.nextInt(10));
        project.setProjectCode("code" + random.nextInt(10));
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
