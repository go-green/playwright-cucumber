/**
 * @author Rasika Ranawaka
 * @filename PageElement
 * @date 22/02/2024
 */
package projectx.components;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page elements are simple web UI controls such as links, buttons and input fields. Base elements class helps page
 * objects to be modular. It provides a single point for Web element initialization. It also abstracts away the
 * Playwright methods from the tests.
 */
public class PageElement extends BaseComponent {

    private By by;

    public PageElement(final Page page, String locator) {
        this.page = page;
        this.locator = locator;
        this.initElement();
    }

    /**
     * String parent
     * Locating an element relative to another element. This helps to narrow down the element location by searching for
     * the element inside a subsection of the DOM rather than the entire DOM
     */
    public PageElement(final Page page, String parent, String locator) {
        this.page = page;
        this.parent = parent;
        this.locator = locator;
        this.initElement();
    }

    /**
     * String parent
     * Locating an element relative to another element. This helps to narrow down the element location by searching for
     * the element inside a subsection of the DOM rather than the entire DOM
     */
    public PageElement(final Page page, String parent, By locator) {
        this.page = page;
        this.parent = parent;
        this.by = locator;
        this.initElement();
    }

    private void initElement() {
        Locator parent = this.page.locator(this.parent);
        if(this.parent == null && this.locator != null) {
            this.element = this.page.locator(this.locator);
            return;
        }
        if (this.locator != null && this.parent != null) {
            this.element = parent.locator(this.locator);
            return;
        }
        if (this.by != null) {
            if (this.by.using == "label") {
                this.element = parent.getByLabel(this.by.locator);
                return;
            }
            if (this.by.using == "placeholder") {
                this.element = parent.getByPlaceholder(this.by.locator);
                return;
            }
            if (this.by.using == "text") {
                this.element = parent.getByText(this.by.locator);
                return;
            }
            if (this.by.using == "exact_text") {
                this.element = parent.getByText(this.by.locator, new Locator.GetByTextOptions().setExact(true));
                return;
            }
        }
        // Add playwright specific element initialization methods as and when needed. The most sought after ones are added above
        throw new RuntimeException("Unable to initialize the element");
    }
}
