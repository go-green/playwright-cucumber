/**
 * @author Rasika Ranawaka
 * @filename BasePageFactory
 * @date 25/01/2024
 */
package projectx.playwright;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projectx.pages.BasePage;

import java.lang.reflect.Constructor;

/**
 * PageFactory provides a single point for page object initialization via reflection.
 */

public class PageFactory {

    private static final Logger logger = LogManager.getLogger(PageFactory.class);

    public static <T extends BasePage> T createInstance(final Page page, final Class<T> clazz) {
        try {
            logger.info(String.format("Initializing page object %s", clazz.getName()));
            Constructor constructor = clazz.getConstructor(Page.class);
            return clazz.cast(constructor.newInstance(page));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
