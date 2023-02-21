package Onliner;

import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;


public class OnlinerTest extends BaseTest {
    @Test
    public void searchTest() {

        driver.get("https://www.onliner.by/");
        MainPage mainPage = new MainPage(driver);

        try {
            mainPage.search();
            Assertions.assertEquals("https://catalog.onliner.by/notebook", driver.getCurrentUrl());

            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void aboutCompanyTest() {

        driver.get("https://www.onliner.by/");
        MainPage mainPage = new MainPage(driver);

        try {
            mainPage.scrollToFooter();
            mainPage.clickAboutCompany();
            Assertions.assertEquals("https://blog.onliner.by/about", driver.getCurrentUrl());

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void cartTest() {

        driver.get("https://catalog.onliner.by/notebook");
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);

        try {


            catalogPage.clickToFirstOfferButton();
            catalogPage.clickToAddToCartButton();
            catalogPage.clickToGoToCartButton();

            Assertions.assertNotNull(cartPage.getProduct());

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void forumTest() {

        driver.get("https://www.onliner.by/");
        MainPage mainPage = new MainPage(driver);

        try {
            mainPage.clickToForumButton();
            Assertions.assertEquals("https://forum.onliner.by/", driver.getCurrentUrl());

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
