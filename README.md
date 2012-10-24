Comment respecter le Single Responsabiltiy Principle ?
======================================================

A partir d'un exemple de code (une classe Cart qui représente un Panier comme on en trouve dans les sites de shopping - repris de l'exemple donné par Xavier Nopre dans son blog), explorer les différentes solutions pour simplifier une classe afin qu'elle n'ait pas trop de responsabilités, et que le code reste facilement maintenable.

Lectures préparatoire conseillées : 
* l'article [Développement et conception : mon approche P(N)OO](http://xnopre.blogspot.fr/2012/10/developpement-et-conception-mon.html) de Xavier Nopre
* un court article sur [Single responsibility principle](http://en.wikipedia.org/wiki/Single_responsibility_principle) (SRP)
* le [Pattern Visitor](http://en.wikipedia.org/wiki/Visitor_pattern) 


Lien
----
* [DOJO ENSIMAG] [61e session du mardi 16 Octobre 2012](http://www.clubagilerhonealpes.org/activites/coding-dojo/932/dojo-ensimag-61e-session-le-1610-salle-h-103)

Branches 
--------
* Master : Cette branche fournit un projet base sur lequel on peut s'entraîner. Il contient une classe Main qui permet d'afficher le corps de message d'un mail récapitulant le contenu du panier et un test d'intégration pour la méthode computeMailContent()..  
* sol1-VisitorPattern : une solution pour réaliser la méthode computeMailContent() en dehors de la classe Cart en utilisant le Pattern Visitor.

Tips
----
Pour lancer les tests unitaires et d'intégration : <code>mvn clean verify</code>

Pour exécuter l'application : <code>mvn exec:java</code>
