/**
 * 1. Перейти на chaihona.ru
 * 2. Перейти в меню доставки - шаурма.
 * 3. Выбрать шаурму с курицей, запомнить название и цену.
 * 4. Выбрать меню доставки - Плов - Плов чайханский - запомнить цену.
 * 5.Перейти в корзину
 * 6. Проверить, что все товары добавлены.
 * 7. Проверить, что итоговая сумма совпадает с суммой выбранных товаров.
 * 8. Удалить все товары из корзины.
 * 9. Проверить, что корзина пустая
 */

import Other.Init;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.BasePageSteps;
import steps.CartPageSteps;
import steps.ProductGreedPageSteps;

public class TestChai {

    @Before
    public void begin(){
        Init.begin(true);
    }

    @After
    public void end(){
        Init.end(false);
    }

    @Test
    public void myTest(){
        BasePageSteps basePageSteps = new BasePageSteps();
        ProductGreedPageSteps productGreedPageSteps = new ProductGreedPageSteps();
        CartPageSteps cartPageSteps = new CartPageSteps();

        //2. Перейти в меню доставки - шаурма.
        basePageSteps.goMenuItem("Бургеры и Шаурма");
        //3. Выбрать шаурму с курицей, запомнить название и цену.
        productGreedPageSteps.orderAndCalcProd("Шаурма с курицей");
        //4. Выбрать меню доставки - Плов - Плов чайханский - запомнить цену.
        basePageSteps.goMenuItem("Плов");
        productGreedPageSteps.orderAndCalcProd("Плов Чайханский");
        //5.Перейти в корзину
        basePageSteps.goToCart();
        //6. Проверить, что все товары добавлены.
        //7. Проверить, что итоговая сумма совпадает с суммой выбранных товаров.
        cartPageSteps.checkProdAndSummInCart();
        //8. Удалить все товары из корзины.
        cartPageSteps.deleteProd();
        //9. Проверить, что корзина пустая
        cartPageSteps.isEmpty();

    }
}
