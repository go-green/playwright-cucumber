/**
 * @author Rasika Ranawaka
 * @filename BrowserManager
 * @date 25/01/2024
 */
package projectx.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import projectx.config.Settings;

public final class BrowserManager {

    private BrowserManager() {}

    public static Browser getBrowser(final Playwright playwright) {
        String browser = Settings.getInstance().getProperty("project_x.playwright.browser", String.class);
        return BrowserFactory.valueOf(browser.toUpperCase()).createInstance(playwright);
    }
}
