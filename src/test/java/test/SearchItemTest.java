package test;

import model.Item;
import fw.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void itemTest(){

        app.Item().goToMarket();
        app.Item().switchToNextTab();
        app.Item().filterItem(
                new Item().setItemType("smartfony/16814639/list?glfilter=4940921%3A13475069&hid=91491")
                        .setPriceFrom("20000")
                        .setPriceTo("35000")
                        .setBrand("Apple"));
        app.Item().refresh();


        String itemName = app.Item().getItemNameFromListByOrder(2);

        app.Item().typeInSearchInputField(itemName);
        String foundItemName = app.Item().getItemNameFromListByOrder(1);
        Assert.assertEquals(foundItemName,itemName);
    }

}