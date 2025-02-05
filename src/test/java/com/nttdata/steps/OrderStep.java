package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class OrderStep {

    //private static final String URL_BASE = "https://petstore.swagger.io/v2/store";
    private String URL_BASE;
    private Response response;

    public void definirUrl(String url) {
        this.URL_BASE = url;
    }

    public void crearOrden(int id, int petId, int cantidad, String status, boolean complete) {
        String body = String.format("{ \"id\": %d, \"petId\": %d, \"quantity\": %d, \"status\": \"%s\", \"complete\": %b }",
                id, petId, cantidad, status, complete);

        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(body)
                .post("/order")
                .then().log().all();

    }

    public void validarCodigoRespuesta(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().statusCode());
    }

    public void validarIdOrden(int idEsperado) {
        int idActual = SerenityRest.lastResponse().jsonPath().getInt("id");
        Assert.assertEquals(idEsperado, idActual);
    }

    public void consultarOrden(int id) {
        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .get("/order/" + id)
                .then().log().all();
    }

    public void validarEstadoOrden(String estadoEsperado) {
        String estadoActual = SerenityRest.lastResponse().jsonPath().getString("status");
        Assert.assertEquals(estadoEsperado, estadoActual);
    }

}
