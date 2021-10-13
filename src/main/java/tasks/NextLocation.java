package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import userinterface.UtestFormStepOne;


public class NextLocation implements Task {
    private String strFirstName;
    private String strLastName;
    private String strEmail;
    private String strBirthMonth;
    private String strBirthDay;
    private String strBirthYear;
    private String strLanguages;

    public NextLocation(String strFirstName, String strLastName, String strEmail, String strBirthMonth, String strBirthDay, String strBirthYear, String strLanguages) {
        this.strFirstName = strFirstName;
        this.strLastName = strLastName;
        this.strEmail = strEmail;
        this.strBirthMonth = strBirthMonth;
        this.strBirthDay = strBirthDay;
        this.strBirthYear = strBirthYear;
        this.strLanguages = strLanguages;
    }


    public static NextLocation onThePage(String strFirstName, String strLastName, String strEmail, String strBirthMonth, String strBirthDay, String strBirthYear, String strLanguages) {
        return Tasks.instrumented(NextLocation.class,strFirstName,strLastName,strEmail,strBirthMonth,strBirthDay,strBirthYear,strLanguages); }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UtestFormStepOne.JOIN_TODAY),
                Enter.theValue(strFirstName).into(UtestFormStepOne.INPUT_FIRST_NAME),
                Enter.theValue(strLastName).into(UtestFormStepOne.INPUT_LAST_NAME),
                Enter.theValue(strEmail).into(UtestFormStepOne.INPUT_EMAIL),
                SendKeys.of(strBirthMonth).into(UtestFormStepOne.INPUT_BIRTH_MONTH),
                SendKeys.of(strBirthDay).into(UtestFormStepOne.INPUT_BIRTH_DAY),
                SendKeys.of(strBirthYear).into(UtestFormStepOne.INPUT_BIRTH_YEAR),
                Enter.theValue(strLanguages).into(UtestFormStepOne.INPUT_LANGUAGES_SPOKEN),
                Click.on(UtestFormStepOne.NEXT_LOCATION_BUTTON)
        );







    }
}
