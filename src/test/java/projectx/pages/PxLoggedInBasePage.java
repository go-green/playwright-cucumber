/**
 * @author Rasika Ranawaka
 * @filename PxLoggedInBasePage
 * @date 22/02/2024
 */
package projectx.pages;

import com.microsoft.playwright.Page;
import projectx.components.PxNavigationPanel;

/**
 * A base page class to hold the common page components available in the UI after a user has logged in.
 */
public abstract class PxLoggedInBasePage extends BasePage {

    public PxLoggedInBasePage(Page page) {
        super(page);
    }

    public abstract void verifyPage();

    public PxMainMenu mainMenu = new PxMainMenu(this.page, "");

    public PxNavigationPanel navigationPanel = new PxNavigationPanel(this.page, "");
}
