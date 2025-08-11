package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ConstructorPage;
import utils.BaseTest;

public class ConstructorNavigationTests extends BaseTest {

    @Test
    @DisplayName("Конструктор: вкладка Булки активируется по клику")
    public void bunsTab() {
        new ConstructorPage().openBuns();
    }

    @Test
    @DisplayName("Конструктор: вкладка Соусы активируется по клику")
    public void saucesTab() {
        new ConstructorPage().openSauces();
    }

    @Test
    @DisplayName("Конструктор: вкладка Начинки активируется по клику")
    public void fillingsTab() {
        new ConstructorPage().openFillings();
    }
}
