# Introducción

En la segunda parte de este proyecto, se trabajarán fundamentalmente las habilidades para el desarrollo de diagramas de casos de uso. Además, se especificará uno de ellos, incluyendo todas las características necesarias para su descripción.

# Diagrama de casos de uso

En el diagrama de casos de uso se han incluido, además de las funcionalidades que tiene actualmente la calculadora, dos nuevos casos de uso que se describen a continuación:

* __Cálculo del BMI__: el índice de masa corporal de una persona se puede calcular mediante la fórmula BMI = masa / altura^2 (kg/m^2)
* __Cálculo del IMM__: el índice de masa muscular de una persona se puede calcular mediante la fórmula IMM = masa muscular / altura^2 (kg/m^2)

![DiagramaUML](https://github.com/GonzaloM786/Health-calculator/assets/149195278/e9e1ba5c-6ca6-4363-b724-ff2cdbb6d6e0)

El diagrama muestra los cuatro cálculos que se puede realizar, los cuales generalizan de `Realizar cálculo`. Todos ellos necesitan además la introducción de los parámetros necesarios.

# Especificación de caso de uso

Para la funcionalidad del cálculo del peso ideal, aquí su descripción:

```xml
Especificación de caso de uso
------------------------------------------
Nombre: Cálculo del peso ideal
Actor principal: Usuario
Ámbito: Calculadora de parámetros de salud
Nivel: Summary
Stakeholders e intereses:
	- Usuario: Desea conocer su peso ideal.
	- Desarrollador del software: Asegurarse de que el cálculo se realiza de manera fiable.
Precondiciones: El usuario introduce parámetros validos.
Garantías mínimas: En caso de error, el sistema devuelve un mensaje indicando la causa del mismo.
Garantía de éxito: El sitema muestra el resultado de manera clara y visual.
Trigger: El usuario selecciona la opción del peso ideal.
Escenario princiapl:
1. El usuario selecciona la opción para el cálculo del peso ideal.
2. El usuario introduce los parámetros requeridos.
3. El sistema devuelve el resultado del cálculo.
Escenarios alternativos:
2a. Los parámetros no son validos.
 2a1. El sistema informa al usuario de la no validez de los parámetros y la razón.
 2a2. El sistema pide al usuario que vuelva a introducir los datos erróneos.
 2a3. El usuario puede cancelar el cálculo o volver a intoducir los parámetros.
```
# Habilidades practicadas

* Uso de git y GitHub.
* Creación de diagramas UML (casos de uso).
* Especificación de casos de uso.
