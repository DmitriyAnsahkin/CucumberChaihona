package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.CartPage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class CartPageSteps {

    CartPage cartPage = new CartPage();
    @Step("Проверка товаров в корзине на соответсвие совершенных ранее дейтсвий")
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
    @Step("Удалить все элементы в корзине")
    public void deleteProd (){
        int count = ProductGreedPageSteps.getProdThatWeChose().size();
        if (count > 0){
            for (int i = 0; i < count; i++) {
                cartPage.clickDelete();
            }
        }

    }
    @Step("Проверяем, что корзина пустая")
    public void isEmpty () {
        cartPage.isCartEmpty();
    }

}
