package steps;

import io.qameta.allure.Step;
import pages.ProductsGridPage;

import java.util.ArrayList;
import java.util.TreeSet;

public class ProductGreedPageSteps {
    ProductsGridPage productsGridPage = new ProductsGridPage();
    private static ArrayList<String> prodThatWeChose = new ArrayList<>();
    private static int totalPrice = 0;
    @Step("Выбрать продукт {0}, запомнить его цену и название")
    public void orderAndCalcProd(String wishProd){
        totalPrice += productsGridPage.getPrice(wishProd);
        prodThatWeChose.add(productsGridPage.getNameProd(wishProd));
        productsGridPage.clickOrderButton(wishProd);
    }

    public static ArrayList<String> getProdThatWeChose() {
        return prodThatWeChose;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }
}
