/**
 * @author Rasika Ranawaka
 * @filename PxMainMenu
 * @date 26/01/2024
 */
package projectx.pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projectx.components.PageComponent;
import projectx.components.PageElement;


public class PxMainMenu extends PageComponent {

    private static final Logger logger = LogManager.getLogger(PxMainMenu.class);

    private static String mainMenuParent = ".main-navigation";

    private PageElement loggedInUserMenu = new PageElement(this.page, mainMenuParent, "");

    private PageComponent logOut = new PageComponent(this.page, "");

    private PageElement search = new PageElement(this.page, mainMenuParent, "");

    public PxMainMenu(Page page, String locator) {
        super(page, locator);
    }

    private void showLogOutMenuContent() {
        logger.info("Expand logout menu");
        this.loggedInUserMenu.scrollIntoView();
        this.loggedInUserMenu.click();
    }

    public void logOut() {
        logger.info("Logging out");
        this.showLogOutMenuContent();
        this.logOut.click();
    }

    public void verifyComponent() {
    }

    public void search() {
        this.search.click();
    }
}
