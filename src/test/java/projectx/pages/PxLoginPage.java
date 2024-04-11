/**
 * @author Rasika Ranawaka
 * @filename PxLoginPage
 * @date 23/01/2024
 */
package projectx.pages;


import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projectx.components.PageElement;
import projectx.components.PxInput;

public final class PxLoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(PxLoginPage.class);

    private String loginFormParent = "";

    private PxInput username = new PxInput(this.page, loginFormParent, "input[name='username']");

    private PxInput password = new PxInput(this.page, loginFormParent, "input[name='password']");

    private PageElement loginButton = new PageElement(this.page, loginFormParent, ".btn-login");

    public PxLoginPage(Page page) {
        super(page);
    }

    @Override
    public void verifyPage() {
        this.username.isReady();
        this.password.isReady();
        this.loginButton.isReady();
    }


    public void navigate() {
        logger.info("Navigating to /ar/login");
        this.navigate("/login");
    }

    public void login(String username, String password) {
        logger.info("Logging in as " + username);
        this.username.fill(username);
        this.password.fill(password);
        this.loginButton.click();
    }
}
