import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Test01 {
    public static void main(String[] args) {
        WebDriver webDriver = new SafariDriver();

        webDriver.get("http://localhost:8080/");

        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());

        webDriver.quit();
    }
}
