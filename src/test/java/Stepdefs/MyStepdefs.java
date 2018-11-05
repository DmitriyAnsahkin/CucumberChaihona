package Stepdefs;

import Other.Init;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import steps.BasePageSteps;
import steps.CartPageSteps;
import steps.ProductGreedPageSteps;

public class MyStepdefs {
    BasePageSteps basePageSteps = new BasePageSteps();
    ProductGreedPageSteps productGreedPageSteps = new ProductGreedPageSteps();
    CartPageSteps cartPageSteps = new CartPageSteps();

    @Before
    public void begin(){
        Init.begin(true);
    }

    @Дано("^открыт сайт чайхона$")
    public void openSite() throws Throwable {
        throw new cucumber.api.PendingException();
    }

    @Когда("^открывается меню и происходит выбор подпункта меню \"(.*)\"$")
    public void OpenMenuItem(String itemMenu) throws Throwable {
        basePageSteps.goMenuItem(itemMenu);
        throw new PendingException();
    }

    @Тогда("^на странице нажимаем заказать на продукте \"(.*)\"$")
    public void orderAndCalcProduct(String wishProd) throws Throwable {
        productGreedPageSteps.orderAndCalcProd(wishProd);
        throw new PendingException();
    }

    @И("^происходит переход в корзину$")
    public void goToCartSD() throws Throwable {
        basePageSteps.goToCart();
        throw new PendingException();
    }

    @И("^происходит проверка всех ранее добавленных товаров на соответвие их названий и общей суммы$")
    public void checkCart() throws Throwable {
        cartPageSteps.checkProdAndSummInCart();
        throw new PendingException();
    }

    @И("^если проверка прошла успешно удаляются все товары из корзины$")
    public void cleanCart() throws Throwable {
        cartPageSteps.deleteProd();
        throw new PendingException();
    }

    @И("^происходит проверка корзины на факт отсутвия в ней товаров$")
    public void cartIsEmpty() throws Throwable {
        cartPageSteps.isEmpty();
        throw new PendingException();
    }
}
