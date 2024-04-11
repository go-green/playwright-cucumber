/**
 * @author Rasika Ranawaka
 * @filename By
 * @date 23/02/2024
 */
package projectx.components;


public class By {

    public String using;

    public String locator;

    public By(String using, String locator) {
        this.using = using;
        this.locator = locator;
    }

    public static By exactText(String locator) {
        return new By("exact_text", locator);
    }

    public static By placeHolder(String locator) {
        return new By("placeholder", locator);
    }
}
