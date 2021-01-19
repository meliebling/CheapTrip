package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".city")
    List<WebElement> resultsList;
    @FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[1]")
    WebElement backButton;


    public boolean searchResultIsDisplayed(){
        return resultsList.size()>0;
    }

    public void clickBackButton() throws InterruptedException {
        backButton.click();
        Thread.sleep(5000);
    }

}
