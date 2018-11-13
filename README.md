# PROJET TAA 

Par Mahmoud JAMMAL et Mouhyi-eddine MOUTARAJJI

## TaaBack

La partie back a été implémentée en Spring, nous avons essayé d'utiliser plusieurs technos vues en cours (Spring Security, Srping Data, Srping Boot).

### Lancement de l'application: 

Tout d'abord il faut installer et Builder l'application via Maven. 
Vous devez aussi changer le chemin dans le Data.sql pour récupérer les fichiers csv qui se trouvent dans le dossier ressources. 

Vous pouvez lancer l'application depuis l'IDE de votre choix, le serveur se lance sur le port 8080.

### Travail effectué

#### Les Données

Notre base de donnée contient 4 tables : Person, Places, Sports . Nous avons ajouté aussi une table Role pour la partie security mais nous n'en avons pas servie. 

Chaque table contient plusieurs attributs: 

Person (id,firstName,LastName,place, email, password,sports,role),

places(id,name),

Sports(id,name,covered) (l'attribut covered(INT) est utilisé pour identifier les sport qui se jouent dans des salles couvertes ou non (0 sport not covered,1 sport covered))


#### Les services 

L'api Rest a été implémenté vie sping avec les annotations @RestController. Nous avons utilisé Swagger pour que L'API soit dévouverable en lecture sur l'url :("http://localhost:8080/swagger-ui.html").

#### Sécurity

Pour la partie sécurité nous avons ajouté une configuration qui est complémentement ouverte.

### Scheduler

Pour prévenir les utilisateurs du sports qui peuvent pratiquer le weekend, nous avons créé une classe scheduler qui envois un mail à chaque person avec les infos requises tous les mardi.  

## TaaFront


### Lancement de l'application: 

Pour lancer l'application il suffit d'éxecuter la commande `ng serve`. L'application se lance sur le port 4200. 


