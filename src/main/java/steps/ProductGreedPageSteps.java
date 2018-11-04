package steps;

import pages.ProductsGridPage;

import java.util.ArrayList;
import java.util.TreeSet;

public class ProductGreedPageSteps {
    ProductsGridPage productsGridPage = new ProductsGridPage();
    private static ArrayList<String> prodThatWeChose = new ArrayList<>();
    private static int totalPrice = 0;

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
