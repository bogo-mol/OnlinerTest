package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
    private final WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"schema-products\"]/div[2]/div/div[3]/div[1]/div/div/div/div[2]/a")
    private WebElement firstOfferButton;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[4]/div[1]/div/div/div[2]/div[1]/a[2]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/main/div/div/div[2]/div[1]/div/div[3]/div/div[4]/div[1]/div/div/div[2]/div[1]/a[2]")
    private WebElement goToCartButton;

    public void clickToFirstOfferButton() {
        firstOfferButton.click();
    }

    public void clickToAddToCartButton() {
        addToCartButton.click();
    }

    public void clickToGoToCartButton() {
        goToCartButton.click();
    }
}
