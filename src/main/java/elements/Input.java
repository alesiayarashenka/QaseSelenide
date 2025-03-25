package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    public String inputLocator = "//*[@name='%s']";
    public String inputLocatorForm = "//*[@id='%s']";
    public static final String inputLocatorCaseForm = "//*[contains(text(), '%s')]/parent::div//*[contains(@class, 'ProseMirror toastui-editor-contents')]";

    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeProjectForm(String text) {
        $x(String.format(inputLocatorForm, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeCaseForm(String text) {
        $x(String.format(inputLocatorCaseForm, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clear() {
        SelenideElement element = $x(String.format(inputLocatorForm, label));
        element.click();
        element.clear();
        return this;
    }
}
