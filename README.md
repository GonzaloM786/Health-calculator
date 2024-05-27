# Práctica 7: Refactorings

## Introducción

Tomando como referencia el código correspondiente a la rama `practica6`, en esta práctica se hará una refactorización de todo el código, con el objetivo de hacer este más legible y aplicar buenas técnicas de programación. A continuación se muestran los distintos `bad smell` localizados y la manera en la que se han resuelto.

## Refactorización

>> Bad smell: interface segregation violation (too many responsabilities)
>> 
>> Refactoring applied and its type: interface segragation (class refactoring)
>> 
>> Changes: the HealthCalc interface has been divided into two interfaces, one for the cardiovascular metrics and another for the metabolic metrics. HealthCalcImpl class now implements these two interfaces. Now the code >> is for flexible since all the methods are not in just one interface.
>> 
>> Number of manual changes: 2 new interfaces. 
>
>> Bad smell: long parameter list and magic numbers (gender not as enum).
>> 
>> Refactoring applied and its type: introduce parameter object (method refactoring), extract class (class refactoring).
>> 
>> NOTE: in order to not change the interface provided by the hospital (refactoring this would mean to not adapt to the client's conditions), the HealthHosptial interface was not changed, as well as the input of the rest >> of the classes that use it (adapter, proxy and decorators). However, the HospitalAdapter class uses HealthCalcImpl, which does implement the new changes, e.g. taking a Persona object instead of a long list of
>> parameters.
>> 
>> Changes: Gender enum and Persona class (extending from Person interface) have been created. Class HealthCalcImpl now take a Persona object as an argument. Tests have been changed to adapt the new functionality. GUI has >> been adapted to the changes.
>> 
>> Number of manual changes: 1 new enum, 1 new interface, 1 new class; 5 classes modified and tests changed.
>
>> Bad smell: dead code
>> 
>> Refactoring applied and its type: remove unused code (method refactoring)
>> 
>> Changes: in the child classes CalculadoraEuropea and CalculadoraAmericana the methods that were just calling the parent class have been deleted. The functionality has been maintained since the parent class is the one >> which implements the functionality.
>> 
>> Number of manual changes: 2 blocks of code deleted. 
>
>> Bad smell: dead code
>> 
>> Refactoring applied and its type: remove unused code (class refactoring)
>> 
>> Changes: due to the refactorings applied before, the interface HealthCalc is no longer used, therefore it has been deleted.
>> 
>> Number of manual changes: 1 interface deleted. 

## Conclusión

Resumiendo, los cambios principales que se han hecho durante la refactorización, han sido la creación de una clase persona, que toma un tipo enum como género. Además la interfaz HealthCalc se ha divido en dos por cuestiones semánticas. Por último se han borrado aquellas partes no necesarias del código, haciendolo más legible y mantenible sin cambiar la funcionalidad.

## Habilidades practicadas

* Uso de git y GitHub
* Aplicación de técnicas de refactorización
* Documentación usando vocabulario específico
