package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import objects.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsListPage extends BasePage {

    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final String PROJECT_NAME_FIELD_XPATH = "//table//a[contains(text(), '%s')]";

    public static SelenideElement OPEN_PROJECT_BUTTON(String name) {
        return $(By.xpath("//a[@href='/project/" + name + "']"));
    }

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage openProjectList(String url) {
        open(url);
        return this;
    }

    public String getExistProjectName(String project) {
        return $x(String.format(PROJECT_NAME_FIELD_XPATH, project)).getText();
    }

    public NewProjectModalPage clickNewProjectButton() {
        new Button().click(CREATE_NEW_PROJECT);
        return new NewProjectModalPage();
    }

    public NewCaseTestModalPage directToCaseForm(Project project) {
        new Button().click(OPEN_PROJECT_BUTTON(project.getProjectCode().toUpperCase()));
        return new NewCaseTestModalPage();
    }
}
