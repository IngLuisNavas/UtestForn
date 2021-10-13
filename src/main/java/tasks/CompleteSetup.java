package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.UtestFormLastStep;

public class CompleteSetup implements Task {
    private String password;
    private String confirmPassword;

    public CompleteSetup(String password, String confirmPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    public static CompleteSetup onThePageFinal(String password, String confirmPassword) {
        return Tasks.instrumented(CompleteSetup.class,password,confirmPassword);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(password).into(UtestFormLastStep.INPUT_PASSWORD),
                Enter.theValue(confirmPassword).into(UtestFormLastStep.CONFIRM_PASSWORD),
                Click.on(UtestFormLastStep.CHECK_TERM_USE),
                Click.on(UtestFormLastStep.CHECK_PRIVACY),
                Click.on(UtestFormLastStep.COMPLETE_SETUP)

        );


    }
}
