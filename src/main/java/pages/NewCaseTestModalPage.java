package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.TestCase;
import waiters.Waiter;

import static com.codeborne.selenide.Selenide.$x;

public class NewCaseTestModalPage extends BasePage {
    private static final SelenideElement SAVE_TEST_CASE = $x("//*[text()='Save']");
    Waiter waiter = new Waiter();

    public NewCaseTestModalPage() {
    }

    public NewCaseTestModalPage isOpened() {
        waiter.waitForPageLoaded();
        SAVE_TEST_CASE.shouldBe(Condition.visible);
        return this;
    }

    public NewCaseTestModalPage fillTestCaseForm(TestCase testCase) {
        isOpened();
        new Input("title").write(testCase.getCaseTitle());
        new Input("Description").writeCaseForm(testCase.getCaseDescription());
        new Input("Pre-conditions").writeCaseForm(testCase.getCasePreConditions());
        new Input("Post-conditions").writeCaseForm(testCase.getCasePostConditions());
        new Dropdown("Status").caseTestFormSelectOption(testCase.getCaseStatus());
        new Dropdown("Priority").caseTestFormSelectOption(testCase.getCasePriority());
        new Dropdown("Severity").caseTestFormSelectOption(testCase.getCaseSeverity());
        new Dropdown("Type").caseTestFormSelectOption(testCase.getCaseType());
        new Dropdown("Layer").caseTestFormSelectOption(testCase.getCaseLayer());
        new Dropdown("Behavior").caseTestFormSelectOption(testCase.getCaseBehavior());
        new Dropdown("Automation status").caseTestFormSelectOption(testCase.getCaseAutomationStatus());
        new Dropdown("Tags").caseTestFormSelectTagOption(testCase.getCaseTag());
        new Button().click(SAVE_TEST_CASE);
        return new NewCaseTestModalPage();
    }
}
