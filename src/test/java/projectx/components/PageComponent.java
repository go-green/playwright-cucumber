/**
 * @author Rasika Ranawaka
 * @filename BaseComponent
 * @date 23/01/2024
 */

package projectx.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


/**
 * Page components are complex subsections of the page that has multiple elements such as panels, tables, searchable
 * drop-downs, date pickers etc... Base component class helps page objects to be modular. It provides a single point
 * for Web element initialization. It also abstracts away the Playwright methods from the tests.
 */
public class PageComponent extends BaseComponent {

    public PageComponent(final Page page, String locator) {
        this.page = page;
        this.locator = locator;
        this.initElement();
    }

    /**
     * String parent
     * Locating an element relative to another element. This helps to narrow down the element location by searching for
     * the element inside a subsection of the DOM rather than the entire DOM
     */
    public PageComponent(final Page page,String parent, String locator) {
        this.page = page;
        this.parent = parent;
        this.locator = locator;
        this.initElement();
    }

    private void initElement() {
        if (this.parent == null && this.locator != null) {
            this.element = this.page.locator(this.locator);
            return;
        }
        /**
         * Locating an element relative to another element. This helps to narrow down the element location by searching for
         * the element inside a subsection of the DOM rather than the entire DOM
         */
        if (this.parent != null && this.locator != null) {
            Locator parent = this.page.locator(this.parent);
            this.element = parent.locator(this.locator);
            return;
        }
        throw new RuntimeException("Unable to initialize the element");
    }
}
