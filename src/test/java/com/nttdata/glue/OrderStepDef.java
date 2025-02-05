package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderStepDef {

    @Steps
    OrderStep store = new OrderStep();

    @Given("la url base del servicio es {string}")
    public void laUrlBaseDelServicioEs(String url) {
        store.definirUrl(url);
    }

    @When("creo una orden con ID {int}, petId {int}, cantidad {int}, estado {string} y completado {string}")
    public void crearOrden(int id, int petId, int cantidad, String status, String complete) {
        store.crearOrden(id, petId, cantidad, status, Boolean.parseBoolean(complete));
    }

    @Then("valido que el código de respuesta sea {int}")
    public void validoQueElCódigoDeRespuestaSea(int statusCode) {
        store.validarCodigoRespuesta(statusCode);
    }

    @And("valido que el ID de la orden sea {int}")
    public void validoQueElIDDeLaOrdenSeaId(int idEsperado) {
        store.validarIdOrden(idEsperado);
    }

    @When("consulto la orden con ID {int}")
    public void consultoLaOrdenConIDId(int id) {
        store.consultarOrden(id);
    }

    @And("valido que el estado de la orden sea {string}")
    public void validoQueElEstadoDeLaOrdenSea(String estadoEsperado) {
        store.validarEstadoOrden(estadoEsperado);
    }

}
