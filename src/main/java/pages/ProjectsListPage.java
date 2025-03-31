package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import objects.Project;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsListPage extends BasePage {

    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final String PROJECT_FIELD_XPATH = "//div[@class='NFxRR3']//*[contains(text(), '%s')]";
    private static final String DIRECT_TO_TEST_CASE_MODAL = "//a[@href='/project/%s'][contains(text(),'%s')]";
    private static final String PROJECT_NAME_XPATH = "//*[text()='%s']";

    public ProjectsListPage isOpened() {
        CREATE_NEW_PROJECT.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage openProjectList(String url) {
        open(url);
        return this;
    }

    public ProjectsListPage clickNewProjectButton() {
        new Button().click(CREATE_NEW_PROJECT);
        return this;
    }

    public String getExistProjectName(String field) {
        return $x(String.format(PROJECT_FIELD_XPATH, field)).getText();
    }

    public ProjectSettingsPage directToCaseForm(String code, String name) {
        new Button().click($x(String.format(DIRECT_TO_TEST_CASE_MODAL, code, name)));
        return new ProjectSettingsPage();
    }

    public boolean projectIsPresentOnList(String name) {
        return $x(String.format(PROJECT_NAME_XPATH, name)).exists();
    }
}
