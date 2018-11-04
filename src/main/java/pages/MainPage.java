package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MainPage extends BasePage{
    @FindBy(xpath="//*[@id='desktopMenuMain']//a[contains(text(), 'Меню доставки')]")
    WebElement menuButton;

    @FindBy(xpath="//*[@id='desktopMenuMain]//*[@id='desktopMenuMain']//a[@href='/catalog']/..//div[@class='main-menu__wrap']/ul[contains(@class, 'main-menu__list')]")
    WebElement menuItems;

    @FindBy(xpath = "//a[@href='/store/cart/index']")
    WebElement cart;

    private static final String menuFormat = "//*[@id='desktopMenuMain']//li[@class='level-2__item']/a[contains(text(),'%s')]";

    public MainPage(){
        super();
    }
    public void clicItemMenu(String itemName){
        WebElement temp = getWebElement(String.format(menuFormat, itemName));
        click(temp);
    }

    public void clickMenuButton(){
        click(menuButton);

    }

    public void clickCart (){
        click(cart);
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }
}
