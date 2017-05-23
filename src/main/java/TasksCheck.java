import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TasksCheck {

    @Parameterized.Parameter(0)
    public Integer id;

    @Parameterized.Parameters(name = "report id = {0}")
    public static Collection data() {
        Object[][] data = new Object[][]{
                {1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15}
        };
        return Arrays.asList(data);
    }

    @Test
    public void reportContainsTable() {
        assertThat("На странице есть таблица", isTableExist(id), is(true));
    }

    private boolean isTableExist(Integer id) {
        WebDriver webDriver = new SafariDriver();
        webDriver.get("http://localhost:8080/report?id=" + id);
        try {
            webDriver.findElement(By.xpath("//table/tbody"));
            webDriver.quit();
            return true;
        }
        catch (Exception e) {
            webDriver.quit();
            return false;
        }
    }
}
