/**
 * @author Rasika Ranawaka
 * @filename PxConfirmationWindow
 * @date 26/02/2024
 */
package projectx.components;

import com.microsoft.playwright.Page;


public class PxConfirmationWindow extends PageComponent {

    private PageElement yesButton = new PageElement(this.page, this.locator, "");

    private PageElement noButton = new PageElement(this.page, this.locator, "");

    public PxConfirmationWindow(Page page, String locator) {
        super(page, locator);
    }

    public void selectYes() {
        this.yesButton.click();
    }

    public void selectNo() {
        this.noButton.click();
    }
}
