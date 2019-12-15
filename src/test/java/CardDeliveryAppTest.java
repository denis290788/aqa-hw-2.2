import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryAppTest {

    @Test
    void shouldConfirmCardDelivery() throws InterruptedException {
        Calendar instance = Calendar.getInstance();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        instance.setTime(dateNow);
        instance.add(Calendar.DAY_OF_MONTH, 4);
        Date confirmedDate =  instance.getTime();

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
 //       $("[data-test-id=date] input").doubleClick().setValue("");
        $("[data-test-id=date] input").doubleClick().setValue(formatForDateNow.format(confirmedDate));
        $("[data-test-id=name] input").setValue("Петрова Анна");
        $("[data-test-id=phone] input").setValue("+79335843723");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);

    }
}
