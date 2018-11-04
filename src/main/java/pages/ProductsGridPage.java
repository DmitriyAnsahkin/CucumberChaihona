package pages;

import Other.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsGridPage extends BasePage {
    private final static String productName = "//h3[@class='product-title']/a/span[contains(text(), '%s')]";
    private final static String productInfo = productName +  "/../../..";
    private final static String productPrice = productInfo + "//span[@class='price']";
    private final static String productOrderButton = productInfo + "//span[contains(text(),'Заказать')]";

    public void clickOrderButton(String wishProduct){
        click(getWebElement(String.format(productOrderButton, wishProduct)));
    }

    public int getPrice (String wishProduct){
        WebElement temp = getWebElement(String.format(productPrice, wishProduct));
        //System.out.println(temp.getText().replaceAll("[^A-Za-zА-Яа-я0-9]", ""));
        return Integer.valueOf(temp.getText().replaceAll("[^A-Za-zА-Яа-я0-9]", ""));
    }

    public String getNameProd (String wishProd){
        return getWebElement(String.format(productName, wishProd)).getText();
    }


    @Override
    public boolean isPageLoaded() {
        return false;
    }
}
