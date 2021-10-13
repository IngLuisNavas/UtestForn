package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.AcademyChoucairData;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.*;

import java.util.List;

public class ChoucairAcademyStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^Felipe wanted to use the registration form in Utest$")
    public void felipeWantedToUseTheRegistrationFormInUtest() {
        OnStage.theActorCalled("Felipe").wasAbleTo(OpenUp.thePage());
    }

    @When("^Felipe completes the fields in the form$")
    public void felipeCompletesTheFieldsInTheForm(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(NextLocation.onThePage(
                academyChoucairData.get(0).getStrFirstName(),
                academyChoucairData.get(0).getStrLastName(),
                academyChoucairData.get(0).getStrEmail(),
                academyChoucairData.get(0).getStrBirthMonth(),
                academyChoucairData.get(0).getStrBirthDay(),
                academyChoucairData.get(0).getStrBirthYear(),
                academyChoucairData.get(0).getStrLanguages()
                )
        );

        OnStage.theActorInTheSpotlight().attemptsTo(NextDevices.onThePageTwo(
                academyChoucairData.get(0).getStrCity(),
                academyChoucairData.get(0).getStrPostalCode(),
                academyChoucairData.get(0).getStrCountry())
        );

        OnStage.theActorInTheSpotlight().attemptsTo(NextLastStep.onThePageThree());
    }

    @Then("^Felipe complete the form$")
    public void felipeCompleteTheForm(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(CompleteSetup.onThePageFinal(
                academyChoucairData.get(0).getPassword(),
                academyChoucairData.get(0).getConfirmPassword())
        );

    }

}
