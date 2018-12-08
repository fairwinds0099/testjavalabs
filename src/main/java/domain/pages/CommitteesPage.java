package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommitteesPage {

    WebDriver driver;

    @FindBy(xpath = "//h1[@class='page-header']")
    private static WebElement committeesPageElement;
    public CommitteesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isCommitteesPageAgricultureLinkDisplayed() {
        return committeesPageElement.equals("Committees");
    }
}