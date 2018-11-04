package pages;

import Other.Init;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CartPage extends BasePage {

    String cartElement = "//tr[@class='cart-item']/td[@class='product-name']/a[1]";
    @FindBy(xpath = "//span[@id='cartPrice']")
    WebElement totalPrice;

    @FindBy(xpath = "//tr[@class='cart-item']//span[contains(text(),'Удалить')]")
    WebElement deleteButton;

    @FindBy(xpath = "//h2[contains(text(), 'Ваша корзина пуста')]")
    WebElement isCartEmpty;


    public ArrayList getNameProdFromTableCart() {
        waitVisible(cartElement);
        List<WebElement> listProd = Init.getDriver().findElements(By.xpath(cartElement));
        ArrayList<String> nameProdList = new ArrayList();
        for (WebElement webElement : listProd) {
            nameProdList.add(webElement.getText());
        }
        return nameProdList;
    }

    public int getTotalSumm() {
        return Integer.valueOf(totalPrice.getText());
    }

    public void clickDelete() {
        click(deleteButton);
    }

    public boolean isCartEmpty() {
        Assert.assertTrue("Корзина не пустая!!!", isCartEmpty.isDisplayed());
        return true;
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }
    //tr[@class='cart-item']

}
