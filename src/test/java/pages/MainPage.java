package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageBase{
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;
    @FindBy(css ="ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLang;
    @FindBy(id = "ion-rb-1-lbl")
    WebElement russianLang;
    @FindBy(css = "ion-item.select-interface-option")
    List<WebElement> langList;
    @FindBy(tagName = "ion-card-title")
    WebElement title;
    @FindBy(css = ".md.button.in-toolbar.in-toolbar-color.ion-activatable.ion-focusable.hydrated")
    WebElement burger;
    @FindBy(id = "inbox-list")
    WebElement homeButton;
    @FindBy(id = "labels-list")
    WebElement contactsButton;
    @FindBy(css = ".split-pane-side.md.menu-type-overlay.menu-enabled.menu-side-start.hydrated.show-menu")
    WebElement pageBody;
    @FindBy(css = "ion-buttons.select.buttons-first-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectCurrency;
    @FindBy(id = "ion-rb-1-lbl")
    WebElement dollarCurrency;
    @FindBy(css = "ion-item.select-interface-option")
    List<WebElement> currencyList;



    public boolean sloganContainsText(String text) {
        return slogan.getText().contains(text);
    }

    public void selectRussianLanguage() {
        selectLang.click();
        waitUntilElementVisible(russianLang, 30);
        langList.get(1).click();
    }

    public boolean isLanguageOnPageRussian() {
        return title.getText().contains("Найдите самый дешевый способ добраться " +
                "из города в город, сочетая самолет, поезд, автобус и " +
                "совместные поездки на автомобиле");
    }

    public void selectDrawer(){
        burger.click();
    }

    public boolean checkBurgerMenuIsPresent(){
        return isElementPresent(homeButton)&&isElementPresent(contactsButton);
    }

    public void selectPageBodyFromDrawer(){
        pageBody.click();
    }

    public void selectContactsFromDrawer(){
        contactsButton.click();
    }

    public void selectDollarCurrency() {
        selectCurrency.click();
        waitUntilElementVisible(dollarCurrency, 30);
        currencyList.get(1).click();
    }
    public boolean isCurrencyDollar() {
        return selectCurrency.getText().contains("USD");
    }





}

