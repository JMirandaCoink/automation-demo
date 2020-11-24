#language: es
  #author: Johan E Miranda.
@index
Característica: Validacion index
  Yo como analista de certificacion
  deseo validar que el servicio de prueba responda
  para efectuar la prueba de concepto

  Escenario: Validar index
    Cuando el analista consume el servico de prueba
    Entonces el analista deberia ver en el codigo de respuesta del servicio un 200
    Y el mensaje 'Hello world!'

