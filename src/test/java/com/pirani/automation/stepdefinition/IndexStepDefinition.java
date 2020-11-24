package com.pirani.automation.stepdefinition;

import com.pirani.automation.tareas.Obtener;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;
import org.omg.CORBA.Environment;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IndexStepDefinition {

    private EnvironmentVariables envVars;

    @Before
    public void preparacionDelEscenario(){
        String baseUrl = envVars.optionalProperty("restapi.baseUrl").orElseThrow(IllegalArgumentException::new);
        SerenityRest.setDefaultParser(Parser.JSON);
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("El Analista").whoCan(CallAnApi.at(baseUrl));
    }

    @Cuando("^el analista consume el servico de prueba$")
    public void elAnalistaConsumeElServicoDePrueba() {
        theActorInTheSpotlight().attemptsTo(Obtener.ElMensaje());
    }

    @Entonces("^el analista deberia ver en el codigo de respuesta del servicio un (\\d+)$")
    public void elAnalistaDeberiaVerEnElCodigoDeRespuestaDelServicioUn(int codigo) {
        theActorInTheSpotlight().should(ResponseConsequence
                .seeThatResponse(response -> response.statusCode(codigo)));
    }

    @Entonces("^el mensaje '(.*)'$")
    public void elMensajeHelloWorld(String mensaje) {
        theActorInTheSpotlight().should(ResponseConsequence
                .seeThatResponse(response -> response.body("message", Matchers.equalTo(mensaje))));
    }
}
