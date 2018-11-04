package steps;

import org.junit.Assert;
import pages.CartPage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class CartPageSteps {

    CartPage cartPage = new CartPage();

    public void checkProdAndSummInCart(){
        ArrayList<String> listProd = cartPage.getNameProdFromTableCart();
        ArrayList<String> test = ProductGreedPageSteps.getProdThatWeChose();
        if (!listProd.equals(test)) {
            Assert.fail("Итоговый список товаров не соответсвует списку товаров записанных вручную при добавлении");
        }
        if (!(ProductGreedPageSteps.getTotalPrice() == cartPage.getTotalSumm())) {
            Assert.fail("Итоговая сумма товаров в корзине не соответсвует сумме посчитанной вручную при добавлении товаров из каталога");
        }
    }

    public void deleteProd (){
        int count = ProductGreedPageSteps.getProdThatWeChose().size();
        if (count > 0){
            for (int i = 0; i < count; i++) {
                cartPage.clickDelete();
            }
        }

    }

    public void isEmpty () {
        cartPage.isCartEmpty();
    }

}
