package fw;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ItemHelper extends HelperBase {
    public ItemHelper(WebDriver wd) {
        super(wd);
    }

    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet']["+number+"]//h3")).getText();
    }

    public void filterItem(Item item) {
        click(By.cssSelector("[href='/catalog--elektronika/54440']"));
        click(By.cssSelector("[href='/catalog--"+ item.getItemType() +"'"));
        //click(By.cssSelector("[data-id='button-all']"));
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());
        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }

    public void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void typeInSearchInputField(String itemName) {
        type(By.cssSelector("#header-search"), itemName);
        click(By.cssSelector("[type='submit']"));
    }
}
