/**
 * @author Rasika Ranawaka
 * @filename BaseComponent
 * @date 23/01/2024
 */
package projectx.components;

import com.microsoft.playwright.Page;

public class PxItemCard extends PageComponent {

    public PxItemCard(Page page, String locator) {
        super(page, locator);
    }

    public PxItemCard(Page page, String parent, String locator) {
        super(page, parent, locator);
    }
}
