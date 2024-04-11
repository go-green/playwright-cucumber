/**
 * @author Rasika Ranawaka
 * @filename BrowserFactory
 * @date 25/01/2024
 */
package projectx.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import projectx.config.Settings;

/**
 * BrowserFactory conditionally initializes a browser instance.
 * It supports CHROMIUM, FIREFOX and WEBKIT based browsers.
 */
public enum BrowserFactory {

    CHROMIUM {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.chromium().launch(options());
        }
    },

    FIREFOX {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.firefox().launch(options());
        }
    },

    WEBKIT {
        @Override
        public Browser createInstance(final Playwright playwright) {
            return playwright.webkit().launch(options());
        }
    };

    public BrowserType.LaunchOptions options() {
        Settings settings = Settings.getInstance();
        Boolean isHeadless = settings.getProperty("project_x.playwright.headless", Boolean.class);
        Integer speed = settings.getProperty("project_x.playwright.speed", Integer.class);
        return new BrowserType.LaunchOptions()
                .setHeadless(isHeadless)
                .setSlowMo(speed);
    }

    public abstract Browser createInstance(final Playwright playwright);
}
