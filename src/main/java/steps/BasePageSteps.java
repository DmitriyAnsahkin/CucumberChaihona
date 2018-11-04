package steps;

import pages.MainPage;

public class BasePageSteps {
    //2. Перейти в меню доставки ...
    MainPage mainPage = new MainPage();

    public void goMenuItem (String itemName){
        mainPage.clickMenuButton();
        mainPage.clicItemMenu(itemName);
    }

    public void goToCart(){
        mainPage.clickCart();
    }
}
