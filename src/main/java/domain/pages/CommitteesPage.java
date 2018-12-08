package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.plugin.javascript.navig.Link;

public class CommitteesPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='http://agriculture.house.gov/']")
    private static WebElement committeesPageLink;

    public CommitteesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isCommitteesPageAgricultureLinkDisplayed() {
        return committeesPageLink.equals("Agriculture");
    }
}