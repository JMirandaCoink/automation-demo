package com.pirani.automation.stepdefinition;

import com.pirani.automation.rutas.Operaciones;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UnitTestStepDefinition {

    private EnvironmentVariables envVars;

    @Before
    public void preparacionDelEscenario(){
        String baseUrl = envVars.optionalProperty("restapi.baseUrl").orElseThrow(IllegalArgumentException::new);
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("El Analista").whoCan(CallAnApi.at(baseUrl));
    }

    @Cuando("^el analista realiza pruebas unitarias$")
    public void elAnalistaRealizaPruebasUnitarias() {
        theActorInTheSpotlight().attemptsTo(Get.resource(Operaciones.obtenerEndPoint("unitTest")));
    }


    @Entonces("^el debria de ver el mensaje '(.*)'$")
    public void elDebriaDeVerElMensajeSuccess(String mensaje) {
        theActorInTheSpotlight().should(ResponseConsequence
                .seeThatResponse(response -> response.body("unitTest", Matchers.equalTo(mensaje))));
    }


}
