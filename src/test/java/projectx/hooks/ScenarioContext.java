/**
 * @author Rasika Ranawaka
 * @filename BeforeAfterScenario
 * @date 11/04/2024
 */
package projectx.hooks;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import projectx.playwright.BrowserManager;

import java.nio.file.Paths;

public class ScenarioContext {

    private static Playwright playwright;

    private static Browser browser;

    private BrowserContext browserContext;

    public Page page;

    @BeforeAll
    public static void beforeAll() {
        playwright = Playwright.create();
        browser = BrowserManager.getBrowser(playwright);
    }

    @Before
    public void beforeScenario() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @After(order = 0)
    public void afterScenario() {
        browser.close();
        playwright.close();
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(String.format(scenario.getName() + ".png")))
                    .setFullPage(true));
        }
        browserContext.close();
    }

    public Page getPage()
    {
        return this.page;
    }
}
