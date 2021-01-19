package tests;

import models.CityData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchTest extends TestBase {


    @DataProvider
    public Iterator<Object[]>validCities() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/citiesData.csv")));
        String line = reader.readLine();
        while(line!=null){
        String[] split = line.split(",");
        list.add(new Object[]{
                new CityData().setCityFrom(split[0]).setCityTo(split[1])});
        line = reader.readLine();
        }
        return list.iterator();
    }

    MainPage mainPage;
    String cityFrom = "Kiev";
    String cityTo = "Moscow";

    SearchPage searchPage;

    @BeforeMethod
    public void initTest() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }



    @Test(dataProvider = "validCities")
    public void searchResultPresentFromDataProvider(CityData cityData) throws InterruptedException {
        mainPage.inputCityFromField(cityData);
        mainPage.inputCityToField(cityData);
        mainPage.clickLetsGoButton();

        Assert.assertTrue(mainPage.searchResultIsDisplayed(),"Search result for " +
                "cities: "+cityFrom+"and"+cityTo+"is not displayed");
        searchPage.clickBackButton();
        mainPage.clickClearAllButton();


    }


}


//    @DataProvider
//    public Iterator<Object[]>validCities(){
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Kiev", "Moscow"});
//        list.add(new Object[]{"Eilat", "Rome"});
//        return list.iterator();
//    }