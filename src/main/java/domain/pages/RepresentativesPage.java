package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepresentativesPage {

    WebDriver driver;

    @FindBy (css = "#state-alabama")
    private static WebElement representativesPageStateName;

    public RepresentativesPage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isRepresentativesPageStateNameDisplayed(){
        return representativesPageStateName.isDisplayed();
    }

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[1]")
    private static WebElement alabamaRowOneColOne;

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[2]")
    private static WebElement alabamaRowOneColTwo;

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[3]")
    private static WebElement alabamaRowOneColThree;

    @FindBy (xpath = "//table[@class='table']/tbody/tr/td[4]")
    private static WebElement alabamaRowOneColFour;

    public static String printAlabamaRowOneColOne() {
        String tableList1 = alabamaRowOneColOne.getText();
        System.out.println(tableList1);
        return tableList1;
    }
    public static String printAlabamaRowOneColTwo() {
        String tableList2 = alabamaRowOneColTwo.getText();
        System.out.println(tableList2);
        return tableList2;
    }
    public static String printAlabamaRowOneColThree() {
        String tableList3 = alabamaRowOneColThree.getText();
        System.out.println(tableList3);
        return tableList3;
    }
    public static String printAlabamaRowOneColFour() {
        String tableList4 = alabamaRowOneColFour.getText();
        System.out.println(tableList4);
        return tableList4;
    }
}


