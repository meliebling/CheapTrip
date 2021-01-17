package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends PageBase{

    public ContactsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".selectable.expand.md.button.button-small.button-solid.ion-activatable.ion-focusable.hydrated")
    WebElement phoneButton;
    @FindBy(xpath = "//*[@class='md title-default hydrated']")
    List<WebElement> titlesInDom;


    public boolean contactsTitlePresent(){
       return titlesInDom.get(0).getText().contains("Contacts");

    }


//    public boolean phoneNumberPresent(String text){
//        return phoneButton.getText().contains(text);
//    }
}
