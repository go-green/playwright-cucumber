/**
 * @author Rasika Ranawaka
 * @filename BaseComponent
 * @date 22/02/2024
 */


package projectx.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projectx.config.Settings;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Common parent for PageElement and BaseComponent classes. Its marked as abstract to avoid direct initialisation
 * and "page" and "element" must be set from a subclass.
 */
public abstract class BaseComponent {

    private static final Logger logger = LogManager.getLogger(BaseComponent.class);

    private static int elementLocatorTimeout = Settings.getInstance().getProperty("project_x.playwright.element.timeout", Integer.class);

    protected Page page;

    protected Locator element;

    protected String parent;

    protected String locator;

    public void isReady() {
        assertThat(this.element).isInViewport(new LocatorAssertions.IsInViewportOptions().setTimeout(elementLocatorTimeout));
        assertThat(this.element).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(elementLocatorTimeout));
        assertThat(this.element).isEnabled(new LocatorAssertions.IsEnabledOptions().setTimeout(elementLocatorTimeout));
    }

    public void focus() {
        logger.info("Focusing on element " + element);
        this.element.focus(new Locator.FocusOptions().setTimeout(elementLocatorTimeout));
    }

    public void scrollIntoView() {
        logger.info("Scrolling into view " + element);
        this.element.scrollIntoViewIfNeeded(new Locator.ScrollIntoViewIfNeededOptions().setTimeout(elementLocatorTimeout));
    }

    /**
     * Use to check if an element is visible on the DOM waiting (Passing wait time as 0)
     */
    public boolean isVisible(int timeout) {
        logger.info(String.format("Check for the visibility of the element %s within %s", this.element, timeout));
        try {
            this.element.waitFor(new Locator.WaitForOptions().setTimeout(timeout));
            return this.element.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled() {
        logger.info("Check if the element is enabled: " + element);
        return this.element.isEnabled(new Locator.IsEnabledOptions().setTimeout(elementLocatorTimeout));
    }

    public void click() {
        logger.info("Click on element: " + element);
        this.element.click();
    }
}
