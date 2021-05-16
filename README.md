# BCGDV
##Setup
To run the application please execute `docker-compose up`

After it is completed requests can be send to http://localhost:8080/checkout via POST. Since it uses Json the request requires headers:
Accept: application/json
Content-Type: application/json

##General description

The application is based on Spring Boot framework and separated into 2 main blocks: checkout and ORM. PostgreSQL is my choice of persistent storage. ORM maps Watch entities to PostgreSQL. Checkout module is responsible for processing of requests and total order price calculations.

CheckoutController receives requests for the endpoint and calls CheckoutFacade which is responsible for the business logic. After the calculation is completed ResponseCreator composes json response.

##Architecture
I use facade design pattern to hide complex business logic. Different modules communicate with each other only through facades. This approach allows to easily change logic behind the facades without modifying other modules which call these facades.

##What I would improve
Checkout business logic could be a separate service which could be easily scaled to multiple pods in case of using Kubernetes. ORM and CheckoutController could be splitted to separate packages to be easily replacable with other storages and other input sources.
