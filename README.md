# Casos de prueba

## Método idealWeight
* Comprobar que se lanza una excepción cuando *height* es menor que 84 para hombre
    Explicación: si se iguala la ecuación a cero, los valores por debajo de 83,33 resultarán en un Ideal Weight negativo, lo cual no tiene sentido.
* Comprobar que se lanza una excepción cuando *height* es menor que 67 para mujer
    Explicación: si se iguala la ecuación a cero, los valores por debajo de 66.66 resultarán en un Ideal Weight negativo, lo cual no tiene sentido.
* Comprobar que se lanza una excepción cuando *height* es mayor que 250
    Explicación: se supone que una persona no puede medir mas de 250 cm 
* Comprobar que el resultado es correcto tanto para hombre como para mujer en el intervalo
* Comprobar que se lanza una excepción cuando *gender* no es 'm' o 'w', sin importar mayúsculas o minúsculas

## Método basalMetabolicRate

* Comprobar que se lanza una excepción cuando *weight* está fuera del intervalo (0, 500]
* Comprobar que se lanza una excepción cuando *height* está fuera del intervalo (0, 250]
* Comprobar que se lanza una excepción cuando *gender* no es 'm' o 'w', sin importar mayúsculas o minúsculas
* Comprobar que se lanza una excepción cuando *age* está fuera del intervalo (0, 150]
* Comprobar que se lanza una excepción cuando el resultado de la función es negativo
* Comprobar que el resultado es correcto cuando los parámetros están dentro de rango
