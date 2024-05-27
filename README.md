# Práctica 7: Refactorings

## Introducción

Tomando como referencia el código correspondiente a la rama `practica6`, en esta práctica se hará una refactorización de todo el código, con el objetivo de hacer este más legible y aplicar buenas técnicas de programación. A continuación se muestran los distintos `bad smell` localizados y la manera en la que se han resuelto.

## Refactorización


>> Bad smell: large class
>>
>> Refactoring applied and its type: extract class (class refactoring)
>>
>> Changes: the HealthCalcImpl class has been divided into two classes, one for the cardiovascular metrics and another for the metabolic metrics. This makes the code opened for extension.
>>
>> Number of manual changes: 2 new classes. 
>
>> Bad smell: long parameter list and magic numbers (gender not as enum).
>> 
>> Refactoring applied and its type: introduce parameter object (method refactoring), extract class (class refactoring).
>> 
>> NOTE: in order to not change the interface provided by the hospital (refactoring this would mean to not adapt to the client's conditions), the HealthHosptial interface was
>> not changed, as well as the input of the rest of the classes that use it (adapter, proxy and decorators). However, the HospitalAdapter class uses the two new classes,
>> CardiovascularMetrics and MetabolicMetrics, which do implement the new changes, e.g. taking a Persona object instead of a long list of parameters.
>> 
>> Changes: Gender enum and Persona class (extending from Person interface) have been created. Classes CardiovascularMetrics and MetabolicMetrics now take a Persona object as an argument.
>> Class HealthHospital and GUI use the new classes. Tests have been changed to check the new classes.
>>
>> Number of manual changes: 1 new enum, 1 new interface, 1 new class; 5 classes modified and tests changed.
>
>> Bad smell: dead code
>> 
>> Refactoring applied and its type: remove unused code (method refactoring)
>> 
>> Changes: in the child classes CalculadoraEuropea and CalculadoraAmericana the methods that were just calling the parent class have been deleted. The functionality has been maintained
>> since the parent class is the one which implements the functionality.
>> 
>> Number of manual changes: 2 blocks of code deleted. 
>
>> Bad smell: dead code
>> 
>> Refactoring applied and its type: remove unused code (class refactoring)
>> 
>> Changes: due to the refactorings applied before, the interface HealthCalc and the class HealthCalcImpl are no longer used, therefore they have been deleted.
>> 
>> Number of manual changes: 1 interface and 1 class deleted. 


## Conclusión

Resumiendo, los cambios principales que se han hecho durante la refactorización, han sido la creación de una clase persona, que toma un tipo enum como género. Además la clase HealthCalcImpl se ha divido en dos por cuestiones semánticas. Por último se han borrado aquellas partes no necesarias del código, haciendolo más legible y mantenible sin cambiar la funcionalidad.

## Habilidades practicadas

* Uso de git y GitHub
* Aplicación de técnicas de refactorización
* Documentación usando vocabulario específico
