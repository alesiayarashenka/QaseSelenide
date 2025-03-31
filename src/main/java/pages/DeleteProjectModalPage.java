package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class DeleteProjectModalPage extends BasePage {
    private static final SelenideElement DELETE_PROJECT_BUTTON_ON_POP_UP = $x("//*[@type='button']//*[contains(text(), 'Delete project')]");

    public DeleteProjectModalPage isOpened() {
        DELETE_PROJECT_BUTTON_ON_POP_UP.shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage clickDeleteProjectButtonOnPopUp() {
        new Button().click(DELETE_PROJECT_BUTTON_ON_POP_UP);
        return new ProjectsListPage();
    }
}
