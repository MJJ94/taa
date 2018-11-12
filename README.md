# PROJET TAA 

## TaaBack

Par Mahmoud JAMMAL et Mouhyi-eddine MOUTARAJJI

## Lancement de l'application: 

Tout d'abord il faut installer et Builder l'application via Maven. 

Vous pouvez lancer l'application depuis l'IDE de votre choix, le serveur se lance sur le port 8080.

## Travail effectué

### Les Données

Notre base de donnée contient 4 tables : Person, Places, Sports . Nous avons ajouté aussi une table Role pour la partie security mais nous n'en avons pas servie. 


### Les services 

L'api Rest a été implémenté vie sping avec les annotations @RestController. Nous avons utilisé Swagger pour que L'API soit dévouverable en lecture sur l'url :("http://localhost:8080/swagger-ui.html").

### Sécurity

Pour la partie sécurité nous avons ajouté une configuration qui est complémentement ouverte.
