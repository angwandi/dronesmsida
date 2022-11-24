## Drones : https://github.com/angwandi/dronesmsida

####view all a drone:
>GET http://localhost:8080/api/v1/drones
####registering a drone:
>POST : http://localhost:8080/api/v1/drones
####loading a drone with medication items:
>PUT http://localhost:8080/api/v1/drones/{{droneId}}
####checking loaded medication items for a given drone:
>GET http://localhost:8080/api/v1/drones/{{droneId}}
####checking available drones for loading:
>GET http://localhost:8080/api/v1/drones/available
####check drone battery level for a given drone:
>GET http://localhost:8080/api/v1/drones/battery/{{droneId}}

- Input/output data format : JSON.
- build and run the application using maven : `mvn spring-boot:run`
- In memory database is used for this application.(H2)
- Database is pre-populated with some data.
- Commit history is available in the repository: https://github.com/angwandi/dronesmsida 
- branch: submission

####Running the jar file: 
- `java -jar drones-0.0.1-SNAP
  SHOT.jar
  ` making you are in the target folder of the root directory of the project.

IDE used: Intellij IDEA