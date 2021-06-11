package fw;

import fw.ItemHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;

    ItemHelper Item;

    public ItemHelper Item() {
        return Item;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://yandex.ru/");

        Item = new ItemHelper(wd);
    }

    public void stop() {
        wd.quit();
    }
}