package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"fast-search\"]/form/input[1]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"search-page\"]/div[2]/ul/li[1]/div/div")
    private WebElement firstCategoryTitle;

    @FindBy(xpath = "//*[@id=\"fast-search-modal\"]/div/div/iframe")
    private WebElement fastSearchModal;

    @FindBy(css = "body > div.layout-container > footer > div > div > div > div.footer-style__part.footer-style__part_1 > ul > li:nth-child(1) > a")
    private WebElement aboutCompanyButton;

    @FindBy(xpath = "/html/body/div[3]/footer")
    private WebElement footer;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/header/div[2]/div/nav/ul[1]/li[7]/a")
    private WebElement forumButton;

    public void search() {
        Actions builder = new Actions(driver);
        builder.moveToElement(searchField)
                .click()
                .sendKeys("Ноутбуки")
                .build()
                .perform();
        driver.switchTo().frame(fastSearchModal);
        getCategoryTitle().click();
    }

    public void clickAboutCompany() {
        aboutCompanyButton.click();
    }

    public void scrollToFooter() {
        Actions builder = new Actions(driver);
        builder.scrollToElement(footer);
    }

    public void clickToForumButton() {
        forumButton.click();
    }

    public WebElement getCategoryTitle() {
        return firstCategoryTitle;
    }
}
