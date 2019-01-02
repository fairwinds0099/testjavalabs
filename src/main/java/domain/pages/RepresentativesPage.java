package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//never use static variable methods in Page Object Factory
//ideally use the same locator type for all
//TODO How many locator types in Page Object Factory?
//Update method names

public class RepresentativesPage {

    WebDriver driver;

    @FindBy (css = "#state-alabama")
    private WebElement representativesPageStateName;
    //private WebElement myWebElement = driver.findElement(By.xpath("#state-alabama"));

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[1]")
    private WebElement alabamaRowOneColOne;

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[2]")
    private WebElement alabamaRowOneColTwo;

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[3]")
    private WebElement alabamaRowOneColThree;

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[4]")
    private WebElement alabamaRowOneColFour;

    public RepresentativesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRepresentativesPageStateNameDisplayed(){
        return representativesPageStateName.isDisplayed();
    }

    public String retreiveAlabamaRowOneColOne() {
        String tableList1 = alabamaRowOneColOne.getText();
        //System.out.println(tableList1);
        return tableList1;
    }
    public String retreiveAlabamaRowOneColTwo() {
        String tableList2 = alabamaRowOneColTwo.getText();
       // System.out.println(tableList2);
        return tableList2;
    }
    public String retreiveAlabamaRowOneColThree() {
        String tableList3 = alabamaRowOneColThree.getText();
       // System.out.println(tableList3);
        return tableList3;
    }
    public String retreiveAlabamaRowOneColFour() {
        String tableList4 = alabamaRowOneColFour.getText();
        //System.out.println(tableList4);
        return tableList4;
    }
}


