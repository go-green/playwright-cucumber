/**
 * @author Rasika Ranawaka
 * @filename PxNavigationPanel
 * @date 26/02/2024
 */
package projectx.components;


import com.microsoft.playwright.Page;

public class PxNavigationPanel extends PageComponent {

    private PageElement collapseButton = new PageElement(this.page, this.locator, "");

    private PageElement expandButton = new PageElement(this.page, this.locator, "");

    private static String collapseWrapper = "";

    public PxNavigationPanel(Page page, String locator) {
        super(page, locator);
    }

    public void collapse() {
        if ("minus" == this.page.locator(collapseWrapper).getAttribute("svgname")) ;
        this.collapseButton.click();
    }

    public void expand() {
        if ("plus" == this.page.locator(collapseWrapper).getAttribute("svgname")) ;
            this.expandButton.click();
    }
}
