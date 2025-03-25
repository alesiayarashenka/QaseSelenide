package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class TestCaseListPage extends BasePage {

    private static final SelenideElement CLOSE_TEST_CASE = $x("//*[@aria-label ='Close']");
    private static final String TEST_CASE_FIELD_XPATH = "//div[@class='avg9d1 tYBglj']//*[contains(text(), '%s')]";
    private static final SelenideElement CREATE_NEW_TEST = $x("//*[text()='New test']");

    public TestCaseListPage() {
    }

    public TestCaseListPage closeCaseTestForm() {
        new Button().click(CLOSE_TEST_CASE);
        return this;
    }

    public String getExistTestCaseField(String field) {
        return $x(String.format(TEST_CASE_FIELD_XPATH, field)).getText();
    }

    public TestCaseListPage openCaseTestForm() {
        new Button().click(CREATE_NEW_TEST);
        return this;
    }

    public TestCaseListPage isOpened() {
        CREATE_NEW_TEST.shouldBe(Condition.visible);
        return this;
    }
}
