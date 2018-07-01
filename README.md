# XSpeedIt

## Contexte

Résolution de l'exercice XSpeedIt pour l'entretien technique de Voyages SNCF (07/2018 - Vincent Queignec).

## Périmètre fonctionnel couvert

* Optimisation du packaging des boxes.

## Technologies utilisées

* Java 1.8
* Maven
* JUnit
* Lombok (à rajouter à l'IDE si nécessaire !)

## Méthodologies

* Git Flow

## Points notables

* Le programme n'a pas de main => maven test ou lancement unitaire des méthodes de test.
* La branche Benchmark n'est pas mergée, checkout pour tester sur une plus grosse volumétrie.
  -> les méthodes de benchmark lèvent l'exception ArticleDoesntFitException aléatoirement ?! Root cause pas encore définie.
  -> Résultats moyens sur ma machine :
        1K elements = 0ms
        10K elements = 7 ms
        100K elements = 10 ms
        1M elements = 100 ms
        10M elements = 6.75 s
