import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TasksCheck {

    @Parameterized.Parameter(0)
    public Integer id;
    @Parameterized.Parameter(1)
    public List<String> expectedHeaders;

    @Parameterized.Parameters(name = "report id = {0}")
    public static Collection data() {
        Object[][] data = new Object[][]{
                {1, new ArrayList<String>(){{
                    add(0,"name");
                    add(1,"surname");
                    add(2,"mark");
                }}},
                {2, new ArrayList<String>(){{
                    add(0,"name");
                    add(1,"surname");
                    add(2,"nomer");
                    add(3,"mark");
                }}},
                {3, new ArrayList<String>(){{
                    add(0,"name");
                    add(1,"surname");
                    add(2,"birthday");
                    add(3,"mark");
                    add(4,"nomer");
                }}},
                {4, new ArrayList<String>(){{
                    add(0,"name");
                    add(1,"surname");
                    add(2,"nomer");
                    add(3,"mark");
                }}},
                {5, new ArrayList<String>(){{
                    add(0,"students count");
                }}},
                {6, new ArrayList<String>(){{
                    add(0,"good students count");
                }}},
                {7, new ArrayList<String>(){{
                    add(0,"good feamle students count");
                }}},
                {8, new ArrayList<String>(){{
                    add(0,"mark");
                    add(1,"count(*)");
                }}},
                {9, new ArrayList<String>(){{
                    add(0,"name");
                    add(1,"prof count");
                }}},
                {10, new ArrayList<String>(){{
                    add(0,"nomer");
                    add(1,"avg mark");
                }}},
                {11, new ArrayList<String>(){{
                    add(0,"surname");
                    add(1,"name");
                    add(2,"relative count");
                }}},
                {12, new ArrayList<String>(){{
                    add(0,"student");
                    add(1,"age");
                }}},
                {13, new ArrayList<String>(){{
                    add(0,"count(*)");
                }}},
                {14, new ArrayList<String>(){{
                    add(0,"surname");
                    add(1,"name");
                }}},
                {15, new ArrayList<String>(){{
                    add(0,"nomer");
                    add(1,"no abroad relative students count");
                }}}

        };
        return Arrays.asList(data);
    }

    @Test
    public void reportContainsTable() {
        assertEquals("Таблица содержит правильные заголовки", expectedHeaders, getHeaders(id));
    }

    private List<String> getHeaders(Integer id) {
        List<String> headers = new ArrayList<String>();
        WebDriver webDriver = new SafariDriver();
        webDriver.get("http://localhost:8080/report?id=" + id);
        try {
            int colCount = webDriver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();

            for (int i = 1; i <= colCount; i++) {
                headers.add(webDriver.findElement(By.xpath("//table/tbody/tr[1]/td["+i+"]")).getText().trim());
            }
            webDriver.quit();
            return headers;
        }
        catch (Exception e) {
            webDriver.quit();
            return null;
        }
    }
}
