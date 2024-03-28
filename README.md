# Introducción

La finalidad de esta parte del proyecto es implementar tests de prueba siguiendo la metodología BDD usando Gherkin y Cucumber. Para ello se ha instalado la extensión correspondiente para el entorno de desarrollo utilizado (Visual Studio).

# Historias de usuario

A continuación se definen dos historias de usuario para los dos casos de uso principales definidos en la práctica anterior. Para cada una, se definen varios escenarios que servirán como criterios de aceptación.

```xml
--------------------------
Ideal weight
--------------------------

User Story

As a calculator user
I want to calculate my ideal weight
So that i know the diet i should follow

Acceptance criteria

Scenario: the parameters are correct
Given the height is correct
And the gender is correct
When i press the calculate button
Then the result is returned

Scenario: the gender is not correct
Given the height is correct
And the gender is not correct
When i press the calculate button
Then an error message indicates the gender is not correct

Scenario: the height is not correct
Given the height is not correct
And the gender is correct
When i press the calculate button
Then an error message indicates the height is not correct

--------------------------
Basal metabolic rate
--------------------------

User Story

As a calculator user
I want to calculate my basal metabolic rate
So that i can accurately design my diet

Acceptance criteria

Scenario: the parameters are correct
Given the height, weight, age and gender are correct
When i press the calculate button
Then the result is returned

Scenario: the gender is not correct
Given the height, weight and age are correct
And the gender is not correct
When i press the calculate button
Then an error message indicates the gender is not correct

Scenario: the result is negative
Given the parameters (e.g. height, weight, age and gender)
When i press the calculate button
Then an error message indicates the parameters are not correct
```

# Implementación de los tests

A partir de las historias de usuario, se implementan estas en su correcto formato en ficheros `.feature`. Después, el software debe pasar los tests de manera exitosa. 

# Habilidades practicadas

* Uso de git y GitHub
* Implementación de historias de usuario
* Generación de tests de prueba usando Gherkin y Cucumber
