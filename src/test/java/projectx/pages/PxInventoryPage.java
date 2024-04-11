package projectx.pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projectx.components.PageElement;
import projectx.pojos.InventoryItem;

import java.util.List;
import java.util.stream.Collectors;

public class PxInventoryPage extends BasePage {

    private static Logger logger = LogManager.getLogger(PxLoginPage.class);

    private String inventoryListLocator = "[data-test='inventory-list']";

    private String inventoryItemLocator = "[data-test='inventory-item']";

    private String inventoryItemNameLocator = "[data-test='inventory-item-name']";

    private String inventoryItemDescLocator = "[data-test='inventory-item-desc']";

    private String inventoryItemPriceLocator = "[data-test='inventory-item-price']";

    private PageElement inventoryList = new PageElement(this.page, inventoryListLocator);

    private List<InventoryItem> inventoryItems;

    public PxInventoryPage(Page page) {
        super(page);
    }

    @Override
    public void verifyPage() {
        this.inventoryList.isReady();
    }

    public List<InventoryItem> getInventoryItems() {
        if(this.inventoryItems != null)
            return inventoryItems;
        return this.page.locator(inventoryListLocator).locator(inventoryItemLocator)
                .all()
                .stream()
                .map(i -> {
                    InventoryItem item = new InventoryItem();
                    item.setName(i.locator(inventoryItemNameLocator).innerText());
                    item.setDescription(i.locator(inventoryItemDescLocator).innerText());
                    item.setPrice(i.locator(inventoryItemPriceLocator).innerText());
                    return item;
                })
                .collect(Collectors.toList());
    }
}
