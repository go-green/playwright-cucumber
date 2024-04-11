package projectx.stepdefinitions;

import com.microsoft.playwright.Page;
import projectx.pages.BasePage;
import projectx.playwright.PageFactory;

/**
 * @author Rasika Ranawaka
 * @filename BaseSteps
 * @date 11/04/2024
 */
public class BaseSteps {

    protected Page page;

    protected <T extends BasePage> T createInstance(Class<T> pageType) {
        return PageFactory.createInstance(this.page, pageType);
    }
}
