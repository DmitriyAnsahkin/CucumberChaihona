package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class BasePageSteps {
    //2. Перейти в меню доставки ...
    MainPage mainPage = new MainPage();

    @Step("Переходим в пункт Меню - {0}")
    public void goMenuItem (String itemName){
        mainPage.clickMenuButton();
        mainPage.clicItemMenu(itemName);
    }
    @Step("Перейти в корзину")
    public void goToCart(){
        mainPage.clickCart();
    }
}
