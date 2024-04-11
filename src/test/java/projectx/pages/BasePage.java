/**
 * @author Rasika Ranawaka
 * @filename BasePage
 * @date 23/01/2024
 */
package projectx.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import projectx.config.Settings;

/**
 * BasePage abstract class contains all common methods and components of a page object.
 */
public abstract class BasePage {

    protected Page page;

    private Page.NavigateOptions navigateOptions;

    public BasePage(final Page page) {
        this.page = page;
        this.navigateOptions = new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED);
    }

    /**
     * Check the readiness of the page elements or page components before start interacting with them in page objects.
     */
    public abstract void verifyPage();

    protected void reload() {
        this.page.reload(new Page.ReloadOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    protected void navigate(String baseUrl, String path) {
        this.page.navigate(String.format("%s%s", baseUrl, path), navigateOptions);
    }

    protected void navigate(String path) {
        String baseUrl = Settings.getInstance().getProperty("project_x.web.ui.base.url",String.class);
        this.page.navigate(String.format("%s%s", baseUrl, path), navigateOptions);
    }
}
