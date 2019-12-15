import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryAppTest {

    @Test
    void shouldConfirmCardDelivery() throws InterruptedException {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").setValue("16.12.2019");
        $("[data-test-id=name] input").setValue("Петрова Анна");
        $("[data-test-id=phone] input").setValue("+79335843723");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();
        $$("[data-test-id=notification]").find(exactText("Встреча успешно забронирована на 16.12.2019")).waitUntil(visible, 1600);

    }
}
