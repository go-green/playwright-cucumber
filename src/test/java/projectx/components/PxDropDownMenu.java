/**
 * @author Rasika Ranawaka
 * @filename PxDropDownMenu
 * @date 26/01/2024
 */
package projectx.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

/**
 * Component to represent a searchable dropdown menu on PRM web portal
 */
public class PxDropDownMenu extends PageComponent {

    private static String dropDownIcon = "";

    private static String getDropDownOptions = "";

    public PxDropDownMenu(Page page, String locator) {
        super(page, locator);
    }

    public PxDropDownMenu(Page page, String parent, String locator) {
        super(page, parent, locator);
    }

    public void listDropDownOptions() {
        this.element.locator(dropDownIcon).click();
    }

    public void selectOption(String option) {
        /**
         * It's this.page here instead of this.element is because, the drop-down content is outside the drop-down menu element
         */
        List<Locator> options = this.page.locator(getDropDownOptions).all();
        Locator filteredOption = options.stream().filter(o -> o.innerText().equals(option)).findFirst().get();
        filteredOption.click();
    }

    public void select(String option) {
        this.listDropDownOptions();
        this.selectOption(option);
    }
}
