package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import objects.Project;

import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalPage extends BasePage {
    private static final SelenideElement CREATE_PROJECT = $x("//*[text()='Create project']");

    public NewProjectModalPage() {
    }

    public NewProjectModalPage isOpened() {
        CREATE_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage fillProjectForm(Project project) {
        isOpened();
        new Input("project-name").writeProjectForm(project.getProjectName());
        new Input("project-code").clear();
        new Input("project-code").writeProjectForm(project.getProjectCode());
        new Input("description-area").writeProjectForm(project.getProjectDescription());
        new Button().click(CREATE_PROJECT);
        return new ProjectsListPage();
    }
}
