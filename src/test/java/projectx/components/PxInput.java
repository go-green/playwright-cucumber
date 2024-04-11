/**
 * @author Rasika Ranawaka
 * @filename PxInput
 * @date 25/01/2024
 */
package projectx.components;

import com.microsoft.playwright.Page;

/**
 * Component to represent input fields on PRM web portal
 */
public final class PxInput extends PageElement {

    public PxInput(Page page, String parent, String locator) {
        super(page, parent, locator);
    }

    public PxInput(Page page, String parent, By locator) {
        super(page, parent, locator);
    }

    public void fill(String text) {
        this.element.fill(text);
    }

    public void clear() {
        this.element.clear();
    }
}
