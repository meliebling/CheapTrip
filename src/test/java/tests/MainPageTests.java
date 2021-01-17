package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.MainPage;

public class MainPageTests extends TestBase{
    MainPage mainPage;
    ContactsPage contactsPage;
    @BeforeMethod
    public void initTest(){
        mainPage = PageFactory.initElements(driver,MainPage.class);
    }

    @Test(priority = 2, groups = {"UI"},enabled = false)
    public void sloganValidationTest(){
        String text = "CheapTrip. Pay less, travel more";
        assert mainPage.sloganContainsText(text);

    }

    @Test(priority = 1, groups = {"functional"}, enabled = false)
    public void changeLanguageValidationTest() throws InterruptedException {
        mainPage.selectRussianLanguage();
        Thread.sleep(500);
        assert mainPage.isLanguageOnPageRussian();

    }

    @Test(priority = 3, groups = {"UI"}, enabled = false)
    public void checkBurgermenuTest() throws InterruptedException {
        mainPage.selectDrawer();
        Thread.sleep(500);
        assert mainPage.checkBurgerMenuIsPresent();
        Thread.sleep(500);
        mainPage.selectPageBodyFromDrawer();
    }


    @Test(priority = 4, groups = {"functional"},enabled=false)//probably issue with shadowdom
    public void checkContactsPageTest() throws InterruptedException {
        mainPage.selectDrawer();
        Thread.sleep(500);
        mainPage.selectContactsFromDrawer();
        Thread.sleep(500);
        assert contactsPage.contactsTitlePresent();
        Thread.sleep(500);
    }

   @Test(priority = 2, groups = {"functional"})
    public void changeCurrencyToDollarTest() throws InterruptedException {
        mainPage.selectDollarCurrency();
        Thread.sleep(500);
        assert mainPage.isCurrencyDollar();
   }

}
