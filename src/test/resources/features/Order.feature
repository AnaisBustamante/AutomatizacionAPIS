@ProbarFeatureStore
Feature: Store

  @CrearOrden
  Scenario Outline: Creación de una Orden
    Given la url base del servicio es "https://petstore.swagger.io/v2/store"
    When creo una orden con ID <id>, petId <petId>, cantidad <cantidad>, estado "<status>" y completado "<complete>"
    Then valido que el código de respuesta sea 200
    And valido que el ID de la orden sea <id>

    Examples:
      | id  | petId | cantidad | status  | complete |
      | 56  | 2001 | 2        | placed  | true     |
      | 57  | 2002 | 1        | pending | false    |

  @ConsultarOrden
  Scenario Outline: Consulta de una Orden
    Given la url base del servicio es "https://petstore.swagger.io/v2/store"
    When consulto la orden con ID <id>
    Then valido que el código de respuesta sea 200
    And valido que el estado de la orden sea "<status>"

    Examples:
      | id  | status  |
      | 56  | placed  |
      | 57  | pending |
