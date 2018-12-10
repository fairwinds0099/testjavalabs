package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommitteesPage {

    WebDriver driver;

    @FindBy(xpath = "//h1[@class='page-header']")
    private static WebElement committeesPageElement;

    @FindBy(css = "#main-content-section > div:nth-child(2) > section > div > article > div > div.page.body > div > section > div > div:nth-child(1)")
    private static WebElement listOfCommitteesPart1;

    @FindBy(css = "#main-content-section > div:nth-child(2) > section > div > article > div > div.page.body > div > section > div > div:nth-child(2)")
    private static WebElement listOfCommitteesPart2;

    public CommitteesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isCommitteesPageAgricultureLinkDisplayed() {
        return committeesPageElement.equals("Committees");
    }

    public static String fetchListOfCommittees() {

        String myListOfCommittees = listOfCommitteesPart1.getText() + listOfCommitteesPart2.getText();
        for (int i=0;i<1;i++) {

            System.out.println(myListOfCommittees);
        }
      return myListOfCommittees;

    }
}


