import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryAppTest {

    @Test
    void shouldConfirmCardDelivery() throws InterruptedException {
        Calendar instance = Calendar.getInstance();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        instance.setTime(dateNow);
        instance.add(Calendar.DAY_OF_MONTH, 3);
        Date confirmedDate =  instance.getTime();

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(formatForDateNow.format(confirmedDate));
        $("[data-test-id=name] input").setValue("Петрова Анна");
        $("[data-test-id=phone] input").setValue("+79335843723");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);

    }

//    @Test
//    void shouldConfirmCardDeliveryV2() {
//        LocalDate currentDate = LocalDate.now().plusDays(7);
//        Date date = java.sql.Date.valueOf(currentDate);
//        //корректируем на время по Гринвичу
//        long dateInMillies = date.getTime() - 3600000 * 3;
//        String dateToCatch = Long.toString(dateInMillies);
//
//        open("http://localhost:9999");
//        $("[data-test-id=city] input").setValue("Сан");
//        $$("[class=menu-item__control]").find(exactText("Санкт-Петербург")).click();
//        $("[data-test-id=date] input").click();
//        $$("[class=calendar-input__calendar-wrapper]").find(exactText(dateToCatch)).click();
//        $("[data-test-id=name] input").setValue("Петрова Анна");
//        $("[data-test-id=phone] input").setValue("+79335843723");
//        $("[data-test-id=agreement]").click();
//        $(byText("Забронировать")).click();
//        $(byText("Успешно!")).waitUntil(visible, 15000);
//
//    }
}
