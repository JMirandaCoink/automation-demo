package com.pirani.automation.tareas;

import com.pirani.automation.rutas.Operaciones;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class Obtener implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Operaciones.obtenerEndPoint("index")));
    }

    public static Obtener ElMensaje(){
        return Tasks.instrumented(Obtener.class);
    }
}
