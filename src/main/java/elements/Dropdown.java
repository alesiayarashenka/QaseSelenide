package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {


    String label;

    private static final String DROPDOWN_XPATH = "//*[text()='%s']/../div";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[text()='%s']";
    private static final String DROPDOWN_TAGS = "(//div[@class=' css-1wy0on6'])[2]";

    public Dropdown(String label) {
        this.label = label;
    }

    public void caseTestFormSelectOption(String option) {
        $(By.xpath(String.format(DROPDOWN_XPATH, label))).click();
        $x(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option)).click();
    }

    public void caseTestFormSelectTagOption(String option) {
        $(By.xpath(String.format(DROPDOWN_TAGS, label))).click();
        $x(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option)).click();
    }
}
