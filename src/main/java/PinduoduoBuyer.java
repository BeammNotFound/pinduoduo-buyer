import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 拼多多秒杀
 *
 * @author BeamStark
 * @date 2022-10-09-16:12
 */
@Slf4j
public class PinduoduoBuyer {

    //购物时间
    private static final String ShoppingTime = "2022-10-09 04:15:00";
    //手机号码
    private static final String PhoneNumber = "";

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver chromeDriver = new ChromeDriver();

        WebDriverWait wait30s = new WebDriverWait(chromeDriver, 30000);
        WebDriverWait wait1s = new WebDriverWait(chromeDriver, 1000);

//        登录界面
        chromeDriver.get("http://panduoduo.yangkeduo.com/login.html?from=http%3A%2F%2Fpanduoduo" +
                ".yangkeduo.com%2Fpersonal.html%3Frefer_page_name%3Dindex%26refer_page_id" +
                "%3D10002_1665303087592_r4p59y4o92%26refer_page_sn%3D10002&refer_page_name" +
                "=personal&refer_page_id=10001_1665303261226_00g71u5lk0&refer_page_sn=10001");
        chromeDriver.findElementByXPath("/html/body/div[1]/div/div[1]/div[2]/div").click();
//        输入手机号
        chromeDriver.findElementByXPath("/html/body/div[1]/div/div[2]/form/div[1]/div[1]/input").sendKeys(PhoneNumber);
        chromeDriver.findElementByXPath("/html/body/div[1]/div/div[2]/form/div[1]/div[2]/button").click();
//        等待输入验证码 进入个人中心
        wait30s.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div" +
                "[1]/div[1]/div[5]"))).click();
//        向下滚动一点
        chromeDriver.executeScript("window.scrollTo(0,250)");

//        进入商品收藏
        wait1s.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2" +
                "]/section/div[3]/div/div[2]/div[1]"))).click();

//        选中第一件商品
        wait1s.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div" +
                "/div" +
                "[2]/div/div[1]/div[2]/div/div/div/div[1]/div"))).click();

        if (LocalDateTime.now().isAfter(LocalDateTime.parse(ShoppingTime,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))) {
            log.info("购买 【{}】 店铺下的 【{}】 商品",
                    chromeDriver.findElementByXPath("/html/body/div[1]/div/div[2]/div/div[1]/div[1" +
                            "]/div/div[1]/div/div[2]/span").getText(),
                    chromeDriver.findElementByXPath("/html/body/div[1]/div/div[2]/div/div[1]/div[2" +
                            "]/div/div/div/div[3]/div[1]/div[1]/div[1]").getText());
        }
        Thread.sleep(5000);
        chromeDriver.quit();

    }
}
