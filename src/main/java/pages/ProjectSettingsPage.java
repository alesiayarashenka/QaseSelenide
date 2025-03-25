package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectSettingsPage extends BasePage {
    private static final SelenideElement CHANGE_LOGO_BUTTON = $x("//*[contains(text(), 'Change logo')]");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//*[contains(text(), ' Delete project')]");
    private static final SelenideElement SETTINGS_BUTTON = $x("//*[@title='Settings']");

    public ProjectSettingsPage isOpened() {
        CHANGE_LOGO_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectSettingsPage clickOnSettingsButton() {
        new Button().click(SETTINGS_BUTTON);
        DELETE_PROJECT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public DeleteProjectModalPage clickDeleteProjectButton() {
        new Button().click(DELETE_PROJECT_BUTTON);
        return new DeleteProjectModalPage();
    }
}
