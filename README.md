Branche sol1-VisitorPattern
===========================

Objectif
--------
Déléguer la responsabilité pour la création du corps du message de mail (cf. méthode computeMailContent()).

Solution : Pattern Visitor
--------------------------
Cette branche présente une solution en utilisant le Pattern Visitor.
Elle inclut des tests unitaires (notamment pour le Pattern Visitor) et un test d'intégration.

Tips
----
Pour lancer les tests unitaires et d'intégration : <code>mvn clean verify</code>

Pour exécuter l'application : <code>mvn exec:java</code>