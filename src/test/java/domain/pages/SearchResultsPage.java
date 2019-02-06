package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends HomePage {


    @FindBy(xpath = "//form[contains(text(), 'Enter a zip code:')]")
    private WebElement invalidZipCodeText;

    @FindBy(xpath = "//img[@class='repPhoto']")
    private WebElement imageRepresentative;

    @FindBy(xpath = "(//img[@class='repPhoto'])[2]")
    private WebElement imageSecondRepresentative;

    @FindBy(xpath = "//input[@value='FIND YOUR REP BY ADDRESS']")
    private WebElement findYourRepByAddressButton;

    @FindBys ({
            @FindBy(xpath = "//*[@id=\"PossibleReps\"]/div/p/a")
    })
    private List<WebElement> yourRepresentatives;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        // this.driver = driver;
    }

    public boolean isFindYourRepByAddressButtonPresent() {
        return findYourRepByAddressButton.isDisplayed();
    }

    public boolean isRepImagePresent() {
        try {
            return imageRepresentative.isDisplayed() || imageSecondRepresentative.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> searchRepResults(){
        List<String> yourReps = new ArrayList<>();
        for(WebElement yr: yourRepresentatives){
            yourReps.add(yr.getText());
        }
        return yourReps;
    }

}
