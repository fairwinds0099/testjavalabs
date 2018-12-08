package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepresentativesPage {

    WebDriver driver;

    @FindBy (css = "#state-alabama")
    private static WebElement RepresentativesPageStateName;

    public RepresentativesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isRepresentativesPageStateNameDisplayed(){
        return RepresentativesPageStateName.isDisplayed();
    }
}
