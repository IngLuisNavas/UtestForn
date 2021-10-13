package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import userinterface.UtestFormStepTwo;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class NextDevices implements Task {
    private String strCity;
    private String strPostalCode;
    private String strCountry;

    public NextDevices(String strCity, String strPostalCode, String strCountry) {
        this.strCity = strCity;
        this.strPostalCode = strPostalCode;
        this.strCountry = strCountry;
    }

    public static NextDevices onThePageTwo(String strCity, String strPostalCode, String strCountry) {
        return Tasks.instrumented(NextDevices.class,strCity,strPostalCode,strCountry);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UtestFormStepTwo.INPUT_CITY, isVisible()).forNoMoreThan(15).seconds(),
                Hit.the(Keys.CLEAR).into(UtestFormStepTwo.INPUT_CITY),
                Enter.theValue(strCity).into(UtestFormStepTwo.INPUT_CITY),
                Hit.the(Keys.ARROW_DOWN, Keys.ENTER).into(UtestFormStepTwo.INPUT_CITY),
                Enter.theValue(strPostalCode).into(UtestFormStepTwo.INPUT_POSTAL_CODE),
                Type.theValue(strCountry).into(UtestFormStepTwo.INPUT_COUNTRY),
                Click.on(UtestFormStepTwo.NEXT_DEVICES)

        );






                /*SendKeys.of("051050").into(UtestFormStepTwo.INPUT_POSTAL_CODE),
                SendKeys.of("Colombia").into(UtestFormStepTwo.INPUT_CITY),
                Click.on(UtestFormStepTwo.NEXT_DEVICES));*/
    }
}
